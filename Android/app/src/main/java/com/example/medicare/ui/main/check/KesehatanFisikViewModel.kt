package com.example.medicare.ui.main.check

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.medicare.data.network.ApiConfig
import com.example.medicare.data.network.DiabetesData
import com.example.medicare.data.network.DiabetesPrediction
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KesehatanFisikViewModel : ViewModel() {

    private val _diabetesPrediction = MutableLiveData<DiabetesPrediction>()
    val diabetesPrediction: LiveData<DiabetesPrediction> = _diabetesPrediction

    companion object {
        private const val TAG = "MainViewModel"
    }

    fun postDiabetesData(
            nik: Long,
            bmi: Double,
            sistole: Double,
            diastole: Double,
            glukosa: Double,
            jumlahKehamilan: Double,
            ketebalanKulit: Double,
            insulin: Int,
            age: Int
    ) {
        val client = ApiConfig.getApiService().postDiabetesData(
                nik,
                bmi,
                sistole,
                diastole,
                glukosa,
                jumlahKehamilan,
                ketebalanKulit,
                insulin,
                age
        )
        client.enqueue(object : Callback<DiabetesPrediction> {
            override fun onResponse(
                    call: Call<DiabetesPrediction>,
                    response: Response<DiabetesPrediction>
            ) {
                if (response.isSuccessful) {
                    _diabetesPrediction.postValue(response.body())
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<DiabetesPrediction>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }
}