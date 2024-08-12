package com.example.montraexpensetracker.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.montraexpensetracker.domain.AuthRepository
import com.example.montraexpensetracker.domain.ForgotPasswordModel
import kotlinx.coroutines.launch

class ForgotPasswordViewModel(private val authRepository: AuthRepository) : ViewModel() {

    private val userforgotPasswordLiveData = MutableLiveData<ForgotPasswordModel?>()

    fun forgotPassword(email: String) {
        viewModelScope.launch {
            try {
                val user = authRepository.userForgotPassword(email)
                userforgotPasswordLiveData.value = user
            } catch (e: Exception) {
                Log.e("ForgotPasswordViewModel", "Error during forgotPassword", e)
            }
        }
    }
}