package com.example.medicare.ui.authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.medicare.R
import com.example.medicare.databinding.ActivitySignupBinding
import com.example.medicare.ui.main.MainActivity

class SignupActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding : ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignup.setOnClickListener(this)
        binding.backToLogin.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            binding.btnSignup -> {
                val i = Intent(this@SignupActivity, MainActivity::class.java)
                startActivity(i)
                finish()
            }
            binding.backToLogin -> {
                finish()
            }
        }
    }
}