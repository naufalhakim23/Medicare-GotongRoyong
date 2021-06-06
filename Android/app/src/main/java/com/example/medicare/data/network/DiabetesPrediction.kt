package com.example.medicare.data.network

import com.google.gson.annotations.SerializedName

data class DiabetesPrediction(
        @SerializedName("code")
        val code: String,
        @SerializedName("diabet_predic")
        val diabetPredic: String,
        @SerializedName("diastole")
        val diastole: String,
        @SerializedName("glukosaDarah")
        val glukosaDarah: String,
        @SerializedName("insulin")
        val insulin: String,
        @SerializedName("jumlahKehamilan")
        val jumlahKehamilan: String,
        @SerializedName("ketebalanKulit")
        val ketebalanKulit: String,
        @SerializedName("NIK")
        val NIK: String,
        @SerializedName("opinion")
        val opinion: String,
        @SerializedName("sistole")
        val sistole: String,
        @SerializedName("BMI")
        val BMI: String
)