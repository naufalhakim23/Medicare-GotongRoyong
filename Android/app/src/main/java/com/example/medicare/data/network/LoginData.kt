package com.example.medicare.data.network

import com.google.gson.annotations.SerializedName

data class LoginData(
        @SerializedName("Email")
        val Email: String,
        @SerializedName("Password")
        val Password: String,

)