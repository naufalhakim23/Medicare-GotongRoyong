package com.example.medicare.ui.main.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import com.example.medicare.R
import com.example.medicare.data.network.DiabetesData
import com.example.medicare.databinding.ActivityKesehatanFisikBinding
import com.example.medicare.databinding.ActivityUpdateFisikBinding
import com.example.medicare.ui.main.MainActivity
import com.example.medicare.ui.main.check.KesehatanFisikActivity
import com.example.medicare.ui.main.check.KesehatanFisikViewModel

class UpdateFisikActivity : AppCompatActivity(), View.OnClickListener {


    private lateinit var etInputAge: EditText
    private lateinit var etInputBMI: EditText
    private lateinit var etInputSistole: EditText
    private lateinit var etInputDiastole: EditText
    private lateinit var etInputGlukosa: EditText
    private lateinit var etInputKehamilan: EditText
    private lateinit var etInputKetebalanKulit: EditText
    private lateinit var etInputInsulin: EditText

    private lateinit var binding : ActivityUpdateFisikBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateFisikBinding.inflate(layoutInflater)
        setContentView(binding.root)

        etInputAge = findViewById(R.id.inputAge)
        etInputBMI = findViewById(R.id.inputBMI)
        etInputSistole = findViewById(R.id.inputSistole)
        etInputDiastole = findViewById(R.id.inputDiastole)
        etInputGlukosa = findViewById(R.id.inputGlukosa)
        etInputKehamilan = findViewById(R.id.inputKehamilan)
        etInputKetebalanKulit = findViewById(R.id.inputKetebalanKulit)
        etInputInsulin = findViewById(R.id.inputInsulin)



        binding.btnSave.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v){
            binding.btnSave -> {
                val bundle = Bundle()
                bundle.putString("InputAge",etInputAge.text.toString())
                bundle.putString("InputBMI",etInputBMI.text.toString())
                bundle.putString("InputSistole",etInputSistole.text.toString())
                bundle.putString("InputDiastole",etInputDiastole.text.toString())
                bundle.putString("InputGlukosa",etInputGlukosa.text.toString())
                bundle.putString("InputKehamilan",etInputKehamilan.text.toString())
                bundle.putString("InputKetebalanKulit",etInputKetebalanKulit.text.toString())
                bundle.putString("InputInsulin",etInputInsulin.text.toString())


                val intent = Intent(applicationContext, KesehatanFisikActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)

            }
        }
    }
}


// make a new View Model (Class) Update