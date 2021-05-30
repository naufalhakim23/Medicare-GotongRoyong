import json
import h5py
from flask import Flask, request

app = Flask(__name__)
diabetes_prediction = h5py.load("model.h5")

@app.route("/")
def hello():
    return "Hello, World!"

@app.route("/predict", methods=["POST"])
def predict():
    request_json = request.json
    print("data: {}".format(request_json))
    print("type: {}".format(type(request_json)))

    prediction = diabetes_prediction.predict(request_json.get('data'))
    prediction_string = [str(d) for d in prediction]
    response_json = {
        "data" : request_json.get("data"),
        "prediction" : list(prediction_string)
    }

    return json.dumps(response_json)

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000)