package com.example.medicare.data.network

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @GET("updateData") // TODO: 2. Nanti diganti sesuai dengan endpoint, tapi tanpa BaseUrl
    fun postDiabetesData(
            @Query("NIK") nik : Long,
            @Query("BMI") bmi : Double,
            @Query("sistole") sistole : Double,
            @Query("diastole") diastole : Double,
            @Query("glukosa") glukosa : Double,
            @Query("jumlahKehamilan") jumlahKehamilan : Double,
            @Query("ketebalanKulit") ketebalanKulit : Double,
            @Query("insulin") insulin : Double,
            @Query("age") age : Int
    ) : Call<DiabetesPrediction>
}