package com.example.medicare.network


import com.google.gson.annotations.SerializedName

data class DiabetesData(
    @SerializedName("Age")
    val age: Int,
    @SerializedName("BMI")
    val bMI: Int,
    @SerializedName("BloodPressure")
    val bloodPressure: Int,
    @SerializedName("Glucose")
    val glucose: Int,
    @SerializedName("Insulin")
    val insulin: Int,
    @SerializedName("Pregnancies")
    val pregnancies: Int,
    @SerializedName("SkinThickness")
    val skinThickness: Int
)