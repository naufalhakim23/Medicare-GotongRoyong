import tensorflow as tf
import uuid
import numpy as np
from flask import Flask, request, jsonify
from keras.models import load_model


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
        #Predict
        x = np.zeros( (1,7))

        x[0,0] = content ['Pregnancies']
        x[0,1] = content ['Glucose']
        x[0,2] = content ['BloodPressure']
        x[0,3] = content ['SkinThickness']
        x[0,4] = content ['Insulin']
        x[0,5] = content ['BMI']
        x[0,6] = content ['Age']

        predict = model.predict(x)
        diabetes_prediction = float(predict[0])
        response = {"id":str(uuid.uuid4()), "Diabetes Prediction":diabetes_prediction}
    else:
        #Return Errors
        response = {"id":str(uuid.uuid4())}

    
    return jsonify(response)

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000, debug=True)