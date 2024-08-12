package com.example.montraexpensetracker.fragments.forgotpassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.montraexpensetracker.R
import com.example.montraexpensetracker.data.remote.FirebaseAuthDataSource
import com.example.montraexpensetracker.data.respository.AuthRepositoryImpl
import com.example.montraexpensetracker.databinding.FragmentForgotPasswordBinding
import com.example.montraexpensetracker.presentation.viewmodel.ForgotPasswordViewModel


class ForgotPasswordFragment : Fragment() {


    private lateinit var binding: FragmentForgotPasswordBinding
    private val authRepository = AuthRepositoryImpl(FirebaseAuthDataSource())
    private val forgotPasswordModel = ForgotPasswordViewModel(authRepository)

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

            componentToolbar.backArrow.setOnClickListener {
                findNavController().navigate(R.id.action_forgotPasswordFragment_to_loginFragment)

            }
            binding.buttonContinue.setOnClickListener {

                val email = binding.textFieldEmailForgotPassword.text.toString().trim()
                if (email.isEmpty()) {

                    Toast.makeText(requireContext(), "Please enter your email", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    forgotPasswordModel.forgotPassword(email)
                    findNavController().navigate(R.id.action_forgotPasswordFragment_to_forgotPasswordSentFragment)
                }
            }
        }
    }
}