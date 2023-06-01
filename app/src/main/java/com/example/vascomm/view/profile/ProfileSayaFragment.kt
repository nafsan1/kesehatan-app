package com.example.vascomm.view.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.vascomm.databinding.FragmentProfileBinding
import com.example.vascomm.databinding.FragmentProfileSayaBinding

class ProfileSayaFragment:Fragment() {

    private lateinit var binding: FragmentProfileSayaBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileSayaBinding.inflate(inflater)
        return binding.root
    }
}