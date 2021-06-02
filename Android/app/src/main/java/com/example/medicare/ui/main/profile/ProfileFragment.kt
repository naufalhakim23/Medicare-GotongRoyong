package com.example.medicare.ui.main.profile

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
import com.example.medicare.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(), View.OnClickListener {

    private lateinit var profileViewModel: ProfileViewModel
    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        profileViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)

        binding.editProfile.setOnClickListener(this)
        return binding.root
    }

    override fun onClick(v: View?) {
        when(v){
            binding.editProfile -> {
                val intent = Intent(context, EditProfileActivity::class.java)
                startActivity(intent)
            }
        }
    }
}