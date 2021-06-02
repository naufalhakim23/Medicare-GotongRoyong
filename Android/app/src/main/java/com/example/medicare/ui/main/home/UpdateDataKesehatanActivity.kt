package com.example.medicare.ui.main.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.medicare.R
import com.example.medicare.databinding.ActivityUpdateDataKesehatanBinding

class UpdateDataKesehatanActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUpdateDataKesehatanBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateDataKesehatanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.kesehatanFisik.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.kesehatanFisik -> {
                val intent = Intent(applicationContext, UpdateFisikActivity::class.java)
                startActivity(intent)
            }
        }
    }
}