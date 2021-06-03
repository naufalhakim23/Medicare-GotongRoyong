package com.example.medicare.data.network

import com.google.gson.annotations.SerializedName

data class RegisterResult(
        @SerializedName("Code")
        val code: String,
        @SerializedName("Nama Lengkap")
        val NamaLengkap: String,
        @SerializedName("NIK")
        val NIK: String,
        @SerializedName("Email")
        val Email: String,

        )