package com.example.medicare.ui.authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.medicare.R
import com.example.medicare.databinding.ActivityLoginBinding
import com.example.medicare.ui.main.MainActivity

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener(this)
        binding.backToSignup.setOnClickListener(this)



    }

    override fun onClick(v: View?) {
        when(v){
            binding.btnLogin -> {

                val i = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(i)
                finish()
            }
            binding.backToSignup -> {
                val i = Intent(this@LoginActivity, SignupActivity::class.java)
                startActivity(i)
            }
        }
    }
}