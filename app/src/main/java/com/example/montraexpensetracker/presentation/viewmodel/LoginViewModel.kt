package com.example.montraexpensetracker.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.montraexpensetracker.domain.AuthRepository
import com.example.montraexpensetracker.domain.UserLoginModel
import kotlinx.coroutines.launch

class LoginViewModel(private val authRepository: AuthRepository) : ViewModel() {

    val userLoginLiveData = MutableLiveData<UserLoginModel?>()

    fun signIn(email: String, password: String) {
        viewModelScope.launch {
            try {
                val user = authRepository.loginUser(email, password)
                userLoginLiveData.value = user
            } catch (e: Exception) {
                Log.e("AuthViewModel", "Error during sign up", e)
            }
        }
    }
}