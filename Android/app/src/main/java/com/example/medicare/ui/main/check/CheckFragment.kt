package com.example.medicare.ui.main.check

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
import com.example.medicare.databinding.FragmentCheckBinding
import com.example.medicare.databinding.FragmentHomeBinding
import com.example.medicare.ui.main.home.HomeViewModel
import com.example.medicare.ui.main.profile.EditProfileActivity

class CheckFragment : Fragment(), View.OnClickListener {

    private lateinit var checkViewModel: CheckViewModel

    private lateinit var binding: FragmentCheckBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCheckBinding.inflate(layoutInflater, container, false)
        checkViewModel = ViewModelProvider(this).get(CheckViewModel::class.java)

        binding.kesehatanFisik.setOnClickListener(this)
        return binding.root
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.kesehatanFisik -> {
                val intent = Intent(context, KesehatanFisikActivity::class.java)
                startActivity(intent)
            }
        }
    }
}