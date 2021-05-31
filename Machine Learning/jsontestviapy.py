import requests

json = {
    "Pregnancies": 6,
    "Glucose": 148,
    "BloodPressure": 72,
    "SkinThickness": 35,
    "Insulin": 3,
    "BMI": 33.6,
    "Age": 50
}

r = requests.post("http://localhost:5000/api/diabetespredict",json=json)
if r.status_code == 200:
    print("Success: {}".format(r.text))
else: print("Failure: {}".format(r.text))