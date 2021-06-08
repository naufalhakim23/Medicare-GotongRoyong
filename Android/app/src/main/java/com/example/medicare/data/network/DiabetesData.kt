package com.example.medicare.data.network


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
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
    val insulin: Double,
    @SerializedName("jumlahKehamilan")
    val jumlahKehamilan: Double,
    @SerializedName("ketebalanKulit")
    val ketebalanKulit: Double,
    @SerializedName("NIK")
    val NIK: Long
) :Parcelable