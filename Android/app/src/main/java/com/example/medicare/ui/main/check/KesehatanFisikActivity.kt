package com.example.medicare.ui.main.check

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.medicare.databinding.ActivityKesehatanFisikBinding

class KesehatanFisikActivity : AppCompatActivity() {

    private lateinit var binding : ActivityKesehatanFisikBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKesehatanFisikBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}