package com.example.medicare.ui.main.profile

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.medicare.databinding.ActivityEditProfileBinding
import com.example.medicare.ui.main.MainActivity

class EditProfileActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding : ActivityEditProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnUpdate.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            binding.btnUpdate -> {
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}