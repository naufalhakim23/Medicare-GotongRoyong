package com.example.medicare.data.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiHasil {
    @GET("getData") // TODO: 2. Nanti diganti sesuai dengan endpoint, tapi tanpa BaseUrl
    fun postDiabetesData(
            @Query("NIK") nik : Long,

    ) : Call<DiabetesPrediction>
}