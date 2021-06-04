import uuid
import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import LabelEncoder
import numpy as np
from flask import Flask, request, jsonify
from keras.models import load_model
from sklearn.preprocessing import StandardScaler


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

@app.route("/api/diabetespredict", methods=["POST"])


def predict_diabetes():
    content = request.json
    errors = []

    if len(errors) <1:
        #defining scaler
        df = pd.read_csv('/mnt/d/Bangkit_Final Project/Medicare-GotongRoyong/Machine Learning/diabetes.csv', sep=",")
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

        x[0,0] = content ['Pregnancies']
        x[0,1] = content ['Glucose']
        x[0,2] = content ['BloodPressure']
        x[0,3] = content ['SkinThickness']
        x[0,4] = content ['Insulin']
        x[0,5] = content ['BMI']
        x[0,6] = content ['Age']

        x   =   scaler.transform(x)
        x   =   x.reshape(1,7,1)

        predict = model.predict(x)
        diabetes_prediction = float((predict[0]))
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

        response = {"Diabetes Prediction":diabetesinto_double, "Opinion":str(output_inword)}


    else:
        #Return Errors
        response = {}



    
    return jsonify(response)

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000, debug=True)