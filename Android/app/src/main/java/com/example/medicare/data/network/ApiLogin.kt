package com.example.medicare.data.network

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiLogin {
    @POST("login") // TODO: 2. Nanti diganti sesuai dengan endpoint, tapi tanpa BaseUrl
    fun postLoginData(
            @Body loginData: LoginData
    ) : Call<LoginResult>

}

