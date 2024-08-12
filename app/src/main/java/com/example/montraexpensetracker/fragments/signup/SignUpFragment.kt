package com.example.montraexpensetracker.fragments.signup

import android.app.Activity.RESULT_OK
import android.content.Intent
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
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class SignUpFragment : Fragment() {
    companion object {
        private const val RC_SIGN_IN = 13
    }

    private lateinit var binding: FragmentSignUpBinding
    private val authRepository = AuthRepositoryImpl(FirebaseAuthDataSource())
    private val firestoreRepository = FirestoreRepositoryImpl(FirebaseFirestoreDataSource())
    private val authViewModel = AuthViewModel(authRepository, firestoreRepository)
    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(requireActivity(), gso)

        binding.apply {
            componentToolbar.textToolbar.text = getString(R.string.text_toolbar_signup)
            componentToolbar.backArrow.setOnClickListener {
                findNavController().navigate(R.id.action_signUpFragment_to_viewPagerFragment)
            }

            textViewLogin1.setOnClickListener {
                findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)

            }

            buttonSignUp.setOnClickListener {
                val name = textFieldName.text.toString().trim()
                val email = textFieldEmail.text.toString().trim()
                val password = textFieldPassword.text.toString().trim()

                if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_SHORT)
                        .show()
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
                            Toast.makeText(requireContext(), "User not created", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }
            }

            buttonLoginGoogle.setOnClickListener {
                googleSignInClient.signOut()
                startActivityForResult(googleSignInClient.signInIntent, RC_SIGN_IN)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN && resultCode == RESULT_OK) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)!!
                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                Toast.makeText(
                    requireContext(),
                    "Google sign in failed: ${e.message}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    findNavController().navigate(R.id.action_signUpFragment_to_signupVerificationFragment)
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Authentication Failed: ${task.exception?.message}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
    }


}
