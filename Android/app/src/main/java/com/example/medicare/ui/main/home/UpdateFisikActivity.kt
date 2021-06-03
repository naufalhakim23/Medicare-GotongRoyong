package com.example.medicare.ui.main.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.medicare.R
import com.example.medicare.databinding.ActivityUpdateFisikBinding
import com.example.medicare.ui.main.MainActivity

class UpdateFisikActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding : ActivityUpdateFisikBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateFisikBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v){
            binding.btnSave -> {
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}

// make a new View Model (Class) Update