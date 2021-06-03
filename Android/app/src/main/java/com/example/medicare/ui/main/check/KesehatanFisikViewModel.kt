package com.example.medicare.ui.main.check

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.medicare.network.ApiConfig
import com.example.medicare.network.DiabetesData
import com.example.medicare.network.DiabetesPrediction
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KesehatanFisikViewModel : ViewModel() {

    private val _diabetesPrediction = MutableLiveData<DiabetesPrediction>()
    val diabetesPrediction: LiveData<DiabetesPrediction> = _diabetesPrediction

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    companion object {
        private const val TAG = "MainViewModel"
    }

    fun getDiabetesPrediction(diabetesData: DiabetesData) {
        _isLoading.value = true
        val client = ApiConfig.getApiService().postDiabetesData(diabetesData)
        client.enqueue(object : Callback<DiabetesPrediction> {
            override fun onResponse(call: Call<DiabetesPrediction>, response: Response<DiabetesPrediction>) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _diabetesPrediction.postValue(response.body())
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<DiabetesPrediction>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }
}