package com.example.medicare.ui.main.check

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import com.example.medicare.R
import com.example.medicare.databinding.ActivityKesehatanFisikBinding

class KesehatanFisikActivity : AppCompatActivity() {

    private lateinit var binding: ActivityKesehatanFisikBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKesehatanFisikBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val model: KesehatanFisikViewModel by viewModels()
        model.diabetesPrediction.observe(this, {
            val percentage = it.diabetesPrediction*100
            findViewById<TextView>(R.id.note1).text= "$percentage%"

            findViewById<TextView>(R.id.note2).text= it.opinion
        })

    }
}



// make a new View Model (Class) Update

// init ViewModel