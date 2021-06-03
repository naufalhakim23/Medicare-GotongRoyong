package com.example.medicare.ui.main.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.medicare.R
import com.example.medicare.databinding.FragmentHomeBinding
import com.example.medicare.ui.main.check.KesehatanFisikActivity
import com.example.medicare.ui.main.profile.EditProfileActivity

class HomeFragment : Fragment(), View.OnClickListener {

    private lateinit var homeViewModel: HomeViewModel

    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // inget dihapus
//        print("hello world")

        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        binding.updatedata.setOnClickListener(this)
        binding.rv1.setOnClickListener(this)
        return binding.root


    }

    override fun onClick(v: View?) {
        when (v) {
            binding.updatedata -> {
                val intent = Intent(context, UpdateDataKesehatanActivity::class.java)
                startActivity(intent)
            }
            binding.rv1 -> {
                val intent = Intent(context, KesehatanFisikActivity::class.java)
                startActivity(intent)
            }
        }
    }
}