package com.example.montraexpensetracker.fragments.forgotpassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.montraexpensetracker.R
import com.example.montraexpensetracker.databinding.FragmentForgotPasswordBinding


class ForgotPasswordFragment : Fragment() {


    private lateinit var binding: FragmentForgotPasswordBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentForgotPasswordBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            componentToolbar.textToolbar.text = getString(R.string.text_toolbar_forgot_password)

            binding.buttonContinue.setOnClickListener {

                findNavController().navigate(R.id.action_forgotPasswordFragment_to_forgotPasswordSentFragment)


            }

        }
    }
}