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

    #check for valid input fields
    for name in content:
        if name in Expected:
            expected_min = Expected[name]['min']
            expected_max = Expected[name]['max']
            value = content[name]
            if value < expected_min or value > expected_max:
                errors.append(f"Out of bounds: {name}, has value of : {value}, but it should between {expected_min} and {expected_max}.")
        else:
            errors.append(f"Unexpected field: {name}.")
        #check for missing input fields
    for name in Expected:
        if name not in content:
            errors.append(f"Missing value: {name}.")
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
        diabetes_prediction = int(predict[0])
        response = {"id":str(uuid.uuid4()), "Diabetes Prediction":diabetes_prediction, "errors":errors}
    else:
        #Return Errors
        response = {"id":str(uuid.uuid4()), "errors":errors}

    print(content['Glucose'])
    return jsonify(response)

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000)