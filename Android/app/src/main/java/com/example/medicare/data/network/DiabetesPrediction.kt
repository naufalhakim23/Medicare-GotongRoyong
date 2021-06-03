package com.example.medicare.data.network

import com.google.gson.annotations.SerializedName

data class DiabetesPrediction(
    @SerializedName("Diabetes Prediction")
    val diabetesPrediction: Double,
    @SerializedName("Opinion")
    val opinion: String
)