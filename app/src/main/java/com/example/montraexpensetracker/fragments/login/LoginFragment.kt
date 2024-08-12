package com.example.montraexpensetracker.fragments.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.montraexpensetracker.R
import com.example.montraexpensetracker.data.remote.FirebaseAuthDataSource
import com.example.montraexpensetracker.data.respository.AuthRepositoryImpl
import com.example.montraexpensetracker.databinding.FragmentLoginBinding
import com.example.montraexpensetracker.presentation.viewmodel.LoginViewModel

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val authRepository = AuthRepositoryImpl(FirebaseAuthDataSource())
    private val loginViewModel = LoginViewModel(authRepository)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginViewModel.userLoginLiveData.observe(viewLifecycleOwner, Observer { userLoginModel ->
            if (userLoginModel != null) {
                findNavController().navigate(R.id.action_loginFragment_to_forgotPasswordFragment)
            } else {
                Toast.makeText(context, "User not signed in", Toast.LENGTH_SHORT).show()
            }
        })

        binding.apply {
            componentToolbar.textToolbar.text = getString(R.string.text_toolbar_login)

componentToolbar.backArrow.setOnClickListener{

    findNavController().navigate(R.id.action_loginFragment_to_viewPagerFragment)

}

textViewSignUp.setOnClickListener {
    findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)

}


            buttonLogin.setOnClickListener {
                val email = textFieldEmail.text.toString().trim()
                val password = textFieldPassword.text.toString().trim()

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(context, "Please fill all fields", Toast.LENGTH_SHORT).show()
                } else {
                    loginViewModel.signIn(email, password)
                }
            }

            textViewForgotPassword.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_forgotPasswordFragment)
            }
        }
    }
}
