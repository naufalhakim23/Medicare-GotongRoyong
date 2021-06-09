import uuid
import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import LabelEncoder
import numpy as np
from flask import Flask, request, jsonify
from keras.models import load_model
from sklearn.preprocessing import StandardScaler

import os
import pymysql


db_user = os.environ.get('CLOUD_SQL_USERNAME')
db_password = os.environ.get('CLOUD_SQL_PASSWORD')
db_name = os.environ.get('CLOUD_SQL_DATABASE_NAME')
db_connection_name = os.environ.get('CLOUD_SQL_CONNECTION_NAME')


app = Flask(__name__)

# load the model, and pass in the custom loss function
model = load_model("diabetes_prediction.h5")
# Used Validation
Expected = {
    "Pregnancies":{},
    "Glucose" : {},
    "BloodPressure" : {},
    "SkinThickness" : {},
    "Insulin" : {},
    "BMI" : {},
    "Age" : {}
}
@app.route("/")
def hello():
    return "Hello, World!"


@app.route("/login")
def sing_in():
    param_email = str(request.args.get("email"))
    param_pass = str(request.args.get("password"))

    if os.environ.get('GAE_ENV') == 'standard':
        # If deployed, use the local socket interface for accessing Cloud SQL
        unix_socket = '/cloudsql/{}'.format(db_connection_name)
        cnx = pymysql.connect(user=db_user, password=db_password,
                              unix_socket=unix_socket, db=db_name)
    else:
        host = '127.0.0.1'
        cnx = pymysql.connect(user=db_user, password=db_password,
                              host=host, db=db_name)
    
    with cnx.cursor() as cursor:
        cursor.execute("select * from register where email='"+param_email+"' and password='"+param_pass+"';")
        result = cursor.fetchall()
    cnx.close()

    if result == 0:
        js = {
            "code": "gagal",
        }
    else:
        js = {
            "code": "sukses",
            "namaLengkap" : result[0][0],
            "NIK" : result[0][1],
            "email" : result[0][2],
        }

    #return str(result[0])
    return jsonify(js)

@app.route("/getData")
def getData():
    param_nik = str(request.args.get("nik"))

    if os.environ.get('GAE_ENV') == 'standard':
        # If deployed, use the local socket interface for accessing Cloud SQL
        unix_socket = '/cloudsql/{}'.format(db_connection_name)
        cnx = pymysql.connect(user=db_user, password=db_password,
                              unix_socket=unix_socket, db=db_name)
    else:
        host = '127.0.0.1'
        cnx = pymysql.connect(user=db_user, password=db_password,
                              host=host, db=db_name)
    
    with cnx.cursor() as cursor:
        cursor.execute("select * from updateData where nik='"+param_nik+"' order by id desc limit 1;")
        result = cursor.fetchall()
    cnx.close()

    if result == 0:
        js = {
            "code": "gagal",
        }
    else:
        js = {
            "code": "sukses",
            "BMI" : str(result[0][1]),
            "NIK" : str(result[0][2]),
            "sistole" : str(result[0][3]),
            "diastole" : str(result[0][4]),
            "glukosaDarah" : str(result[0][5]),
            "jumlahKehamilan" : str(result[0][6]),
            "ketebalanKulit" : str(result[0][7]),
            "insulin" : str(result[0][8]),
            "diabet_predic":str(result[0][9]), 
            "opinion":str(result[0][10])
        }

    #return str(result)
    return jsonify(js)
    

@app.route("/register")
def register():
    param_namaLengkap = request.args.get("nameLengkap")
    param_nik = request.args.get("nik")
    param_email = request.args.get("email")
    param_pass = request.args.get("password")


    if os.environ.get('GAE_ENV') == 'standard':
        # If deployed, use the local socket interface for accessing Cloud SQL
        unix_socket = '/cloudsql/{}'.format(db_connection_name)
        cnx = pymysql.connect(user=db_user, password=db_password,
                              unix_socket=unix_socket, db=db_name)
    else:
        host = '127.0.0.1'
        cnx = pymysql.connect(user=db_user, password=db_password,
                              host=host, db=db_name)
    
    with cnx.cursor() as cursor:
        cursor.execute("insert into register(namaLengkap, NIK, email, password) values ('"+param_namaLengkap+"', '"+param_nik+"', '"+param_email+"', '"+param_pass+"');")
        result = cursor.fetchone()
        cnx.commit()
    cnx.close()

    with cnx.cursor() as cursor:
        cursor.execute("select * from register where email='"+param_email+"' and password='"+param_pass+"';")
        result = cursor.fetchall()
    cnx.close()

    if result == 0:
        js = {
            "code": "gagal",
        }
    else:
        js = {
            "code": "sukses",
            "namaLengkap" : result[0][0],
            "NIK" : result[0][1],
            "email" : result[0][2],
        }

    return jsonify(js)

@app.route("/updateData")
def predict_diabetes():
    param_NIK = request.args.get("NIK")
    param_BMI = request.args.get("BMI")
    param_sistole = request.args.get("sistole")
    param_diastole = request.args.get("diastole")
    param_glukosa = request.args.get("glukosa")
    param_jumlahKehamilan = request.args.get("jumlahKehamilan")
    param_ketebalanKulit = request.args.get("ketebalanKulit")
    param_insulin = request.args.get("insulin")
    param_age = request.args.get("age")

    content = request.json
    errors = []

    if len(errors) <1:
        #defining scaler
        df = pd.read_csv('diabetes.csv', sep=",")
        df_dropped = df.drop(['DiabetesPedigreeFunction'], axis = 1)
        x = df_dropped.drop('Outcome',axis=1)
        y = df_dropped['Outcome']
        le = LabelEncoder()
        y = le.fit_transform(y)
        x_train,x_test,y_train,y_test = train_test_split(x,y,test_size=0.2, shuffle = True, stratify=y)
        scaler = StandardScaler()
        x_train = scaler.fit_transform(x_train)
        #Predict

        x = np.zeros( (1,7))

        x[0,0] = param_jumlahKehamilan
        x[0,1] = param_glukosa
        x[0,2] = param_sistole
        x[0,3] = param_ketebalanKulit
        x[0,4] = param_insulin
        x[0,5] = param_BMI
        x[0,6] = param_age

        x   =   scaler.transform(x)
        x   =   x.reshape(1,7,1)

        predict = model.predict(x)
        diabetes_prediction = float(predict[0])
        diabetesinto_double = float("{:.2f}".format(round(diabetes_prediction*100, 2)))

        if diabetes_prediction <= float(0.3):
            a   =   ("Resiko diabetes rendah")
            output_inword = a
        elif diabetes_prediction <= float(0.7):
            b   =   ("Resiko diabetes Sedang, mohon periksa ke Rumah Sakit terdekat")
            output_inword = b
        elif diabetes_prediction <= float(1):
            c = ("Resiko diabetes TINGGI, mohon segera lakukan pemeriksaan ke Rumah Sakit terdekat")
            output_inword = c

        response = {"id":str(uuid.uuid4()), "Diabetes Prediction":diabetes_prediction, "Opinion":str(output_inword)}


    else:
        #Return Errors
        response = {"id":str(uuid.uuid4())}



    if os.environ.get('GAE_ENV') == 'standard':
        # If deployed, use the local socket interface for accessing Cloud SQL
        unix_socket = '/cloudsql/{}'.format(db_connection_name)
        cnx = pymysql.connect(user=db_user, password=db_password,
                              unix_socket=unix_socket, db=db_name)
    else:
        host = '127.0.0.1'
        cnx = pymysql.connect(user=db_user, password=db_password,
                              host=host, db=db_name)

    with cnx.cursor() as cursor:
        cursor.execute("insert into updateData(NIK,BMI, sistole, diastole, glukosaDarah, jumlahKehamilan, ketebalanKulit, insulin, diabet_predict,opinion) values ('"+str(param_NIK)+"','"+str(param_BMI)+"', '"+str(param_sistole)+"', '"+str(param_diastole)+"', '"+str(param_glukosa)+"', '"+str(param_jumlahKehamilan)+"', '"+str(param_ketebalanKulit)+"', '"+str(param_insulin)+"','"+str(diabetesinto_double)+"','"+str(output_inword)+"');")
        result = cursor.fetchall()
        cnx.commit()
    cnx.close()

    js = {
            "code": "sukses",
            "NIK" : str(param_NIK),
            "BMI" : str(param_BMI),
            "sistole" : str(param_sistole),
            "diastole" : str(param_diastole),
            "glukosaDarah" : str(param_glukosa),
            "jumlahKehamilan" : str(param_jumlahKehamilan),
            "ketebalanKulit" : str(param_ketebalanKulit),
            "insulin" : str(param_insulin),
            "diabet_predic":diabetesinto_double, 
            "opinion":str(output_inword)
        }
    
    return jsonify(js)

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000, debug=True)