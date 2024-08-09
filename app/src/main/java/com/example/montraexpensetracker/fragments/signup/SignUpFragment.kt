package com.example.montraexpensetracker.fragments.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.montraexpensetracker.R
import com.example.montraexpensetracker.data.remote.FirebaseAuthDataSource
import com.example.montraexpensetracker.data.remote.FirebaseFirestoreDataSource
import com.example.montraexpensetracker.data.respository.AuthRepositoryImpl
import com.example.montraexpensetracker.data.respository.FirestoreRepositoryImpl
import com.example.montraexpensetracker.databinding.FragmentSignUpBinding
import com.example.montraexpensetracker.presentation.viewmodel.AuthViewModel

class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding
    private val authRepository = AuthRepositoryImpl(FirebaseAuthDataSource())
    private val firestoreRepository = FirestoreRepositoryImpl(FirebaseFirestoreDataSource())
    private val authViewModel = AuthViewModel(authRepository, firestoreRepository)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            componentToolbar.textToolbar.text = getString(R.string.text_toolbar_signup)
        }
        binding.buttonSignUp.setOnClickListener {
            val name = binding.textFieldName.text.toString().trim()
            val email = binding.textFieldEmail.text.toString().trim()
            val password = binding.textFieldPassword.text.toString().trim()

            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(context, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else {
                authViewModel.signUp(name, email, password)
                authViewModel.userLiveData.observe(viewLifecycleOwner) { userModel ->
                    if (userModel != null) {
                        val bundle = Bundle().apply {
                            putString("email", email)
                        }
                        findNavController().navigate(
                            R.id.action_signUpFragment_to_signupVerificationFragment,
                            bundle
                        )
                    } else {
                        Toast.makeText(context, "User not created", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}