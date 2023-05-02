package com.example.yolharakati.Fragmentlar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.yolharakati.R
import com.example.yolharakati.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {
    private lateinit var binding: FragmentAboutBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentAboutBinding.inflate(layoutInflater)
        binding.infoBack.setOnClickListener {
            findNavController().navigate(R.id.homeFragment)
        }
        return binding.root
    }

}