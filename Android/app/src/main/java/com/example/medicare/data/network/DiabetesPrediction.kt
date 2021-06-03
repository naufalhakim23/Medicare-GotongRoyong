package com.example.medicare.network

import com.google.gson.annotations.SerializedName

data class DiabetesPrediction(
    @SerializedName("Diabetes Prediction")
    val diabetesPrediction: Double,
    @SerializedName("Opinion")
    val opinion: String
)