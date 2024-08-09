package com.example.montraexpensetracker.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.montraexpensetracker.domain.AuthRepository
import com.example.montraexpensetracker.domain.FirestoreRepository
import com.example.montraexpensetracker.domain.UserModel
import kotlinx.coroutines.launch

class AuthViewModel(
    private val authRepository: AuthRepository,
    private val firestoreRepository: FirestoreRepository
) : ViewModel() {

    val userLiveData = MutableLiveData<UserModel?>()
    fun signUp(name: String, email: String, password: String) {
        viewModelScope.launch {
            try {
                val user = authRepository.signUp(name, email, password)
                user?.let {
                    firestoreRepository.saveUser(it)
                }
                userLiveData.value = user
            } catch (e: Exception) {
                Log.e("AuthViewModel", "Error during sign up", e)
            }
        }
    }


}
