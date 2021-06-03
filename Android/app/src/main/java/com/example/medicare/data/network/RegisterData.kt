package com.example.medicare.data.network

import com.google.gson.annotations.SerializedName

data class RegisterData(
        //Nama Lengkap, Nomor Induk Kependudukan, Email, Password

        @SerializedName("Nama Lengkap")
        val NamaLengkap: String,
        @SerializedName("NIK")
        val NIK: String,
        @SerializedName("Email")
        val Email: String,
        @SerializedName("Password")
        val Password: String,
        )

