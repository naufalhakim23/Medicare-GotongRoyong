package com.example.medicare.data.network

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST("updateData") // TODO: 2. Nanti diganti sesuai dengan endpoint, tapi tanpa BaseUrl
    fun postDiabetesData(
        @Body diabetesData: DiabetesData
    ) : Call<DiabetesPrediction>



}