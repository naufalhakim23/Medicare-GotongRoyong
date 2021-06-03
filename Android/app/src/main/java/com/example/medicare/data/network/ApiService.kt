package com.example.medicare.network

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST("endpoint") // TODO: 2. Nanti diganti sesuai dengan endpoint, tapi tanpa BaseUrl
    fun postDiabetesData(
        @Body diabetesData: DiabetesData
    ) : Call<DiabetesPrediction>



}