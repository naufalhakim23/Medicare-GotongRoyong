package com.example.medicare.ui.main.check

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import com.example.medicare.R
import com.example.medicare.databinding.ActivityKesehatanFisikBinding

class KesehatanFisikActivity : AppCompatActivity() {

    private lateinit var isiInsulin: TextView
    private lateinit var isiSistole: TextView
    private lateinit var isiDiastole: TextView
    private lateinit var isiGlukosaDarah: TextView
    private lateinit var isiBMI: TextView
    private lateinit var isiKehamilan: TextView
    private lateinit var isiKetebalanKulit: TextView
    private lateinit var isiUmur: TextView


    private lateinit var binding: ActivityKesehatanFisikBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKesehatanFisikBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val model: KesehatanFisikViewModel by viewModels()
        model.diabetesPrediction.observe(this, {
            val percentage = it.diabetPredic
            findViewById<TextView>(R.id.note1).text= "$percentage%"

            findViewById<TextView>(R.id.note2).text= it.opinion
//            findViewById<TextView>(R.id.isiDiastole).text = it.diastole
//            findViewById<TextView>(R.id.isiSistole).text = it.sistole
//            findViewById<TextView>(R.id.isiGlukosaDarah).text = it.glukosaDarah
//            findViewById<TextView>(R.id.isiBMI).text = it.BMI
//            findViewById<TextView>(R.id.isiKehamilan).text = it.jumlahKehamilan
//            findViewById<TextView>(R.id.isiKetebalanKulit).text = it.ketebalanKulit
//            findViewById<TextView>(R.id.isiInsulin).text = it.insulin
        })


        isiInsulin = findViewById(R.id.isiInsulin)
        isiBMI = findViewById(R.id.isiBMI)
        isiKehamilan = findViewById(R.id.isiKehamilan)
        isiKetebalanKulit = findViewById(R.id.isiKetebalanKulit)
        isiGlukosaDarah = findViewById(R.id.isiGlukosaDarah)
        isiSistole = findViewById(R.id.isiSistole)
        isiDiastole = findViewById(R.id.isiDiastole)
        isiUmur = findViewById(R.id.isiUmur)

        if(intent.extras !=null) {
            val bundle = intent.extras

            val insulinValue = bundle?.getString("InputInsulin")
            isiInsulin.setText(insulinValue)

            val diastoleValue = bundle?.getString("InputDiastole")
            isiDiastole.setText(diastoleValue)

            val sistoleValue = bundle?.getString("InputSistole")
            isiSistole.setText(sistoleValue)

            val glukosaDarahValue = bundle?.getString("InputGlukosa")
            isiGlukosaDarah.setText(glukosaDarahValue)

            val kehamilanValue = bundle?.getString("InputKehamilan")
            isiKehamilan.setText(kehamilanValue)

            val bmiValue = bundle?.getString("InputBMI")
            isiBMI.setText(bmiValue)

            val ketebalanKulitValue = bundle?.getString("InputKetebalanKulit")
            isiKetebalanKulit.setText(ketebalanKulitValue)

            val umurValue = bundle?.getString("InputAge")
            isiUmur.setText(umurValue)

//            val isiInsulin = isiInsulin.setText(bundle?.getString("InputInsulin"))
//            val isiDiastole = isiDiastole.setText(bundle?.getString("InputDiastole"))
//            val isiSistole = isiSistole.setText(bundle?.getString("InputSistole"))
//            val isiGlukosaDarah = isiGlukosaDarah.setText(bundle?.getString("InputGlukosa"))
//            val isiKehamilan = isiKehamilan.setText(bundle?.getString("InputKehamilan"))
//            val isiBMI = isiBMI.setText(bundle?.getString("InputBMI"))
//            val isiKetebalanKulit = isiKetebalanKulit.setText(bundle?.getString("InputKetebalanKulit"))
//            val isiUmur = isiUmur.setText(bundle?.getString("InputAge"))

            model.postDiabetesData(582582925, bmiValue?.toDouble()!!, sistoleValue?.toDouble()!!,diastoleValue?.toDouble()!!,glukosaDarahValue?.toDouble()!!,kehamilanValue?.toDouble()!!, ketebalanKulitValue?.toDouble()!!, insulinValue?.toDouble()!!,umurValue?.toInt()!!)
        }



    }
}



// make a new View Model (Class) Update

// init ViewModel