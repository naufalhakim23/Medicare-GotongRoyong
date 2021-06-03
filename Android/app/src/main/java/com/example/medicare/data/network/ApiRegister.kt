package com.example.medicare.data.network

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiRegister {
    @POST("updateData") // TODO: 2. Nanti diganti sesuai dengan endpoint, tapi tanpa BaseUrl
    fun postRegisterData(
            @Body registerData: RegisterData
    ) : Call<RegisterResult>
}