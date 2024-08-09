package com.example.montraexpensetracker.fragments.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.montraexpensetracker.databinding.FragmentSignupVerificationBinding

class SignupVerificationFragment : Fragment() {

    private lateinit var binding: FragmentSignupVerificationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignupVerificationBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val email = arguments?.getString("email")

        binding.textViewCheckEmail.text =
            "We sent a verification code to your email $email. You can check your inbox."

    }
}