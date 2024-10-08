package com.example.montraexpensetracker.fragments.forgotpassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.montraexpensetracker.R
import com.example.montraexpensetracker.databinding.FragmentForgotPasswordSentBinding

class ForgotPasswordSentFragment : Fragment() {

    private lateinit var binding: FragmentForgotPasswordSentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentForgotPasswordSentBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            binding.buttonBackToLogin.setOnClickListener {

                findNavController().navigate(R.id.action_forgotPasswordSentFragment_to_loginFragment)
            }
        }
    }
}