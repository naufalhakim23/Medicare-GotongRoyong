package com.example.medicare.data.network


import com.google.gson.annotations.SerializedName

data class DiabetesData(
    @SerializedName("age")
    val age: Int,
    @SerializedName("BMI")
    val BMI: Double,
    @SerializedName("sistole")
    val sistole: Double,
    @SerializedName("diastole")
    val diastole: Double,
    @SerializedName("glukosa")
    val glukosa: Double,
    @SerializedName("insulin")
    val insulin: Int,
    @SerializedName("jumlahKehamilan")
    val jumlahKehamilan: Double,
    @SerializedName("ketebalanKulit")
    val ketebalanKulit: Double,
    @SerializedName("NIK")
    val NIK: Int
)