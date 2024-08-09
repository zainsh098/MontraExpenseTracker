package com.example.montraexpensetracker.data.respository

import com.example.montraexpensetracker.data.remote.FirebaseAuthDataSource
import com.example.montraexpensetracker.domain.AuthRepository
import com.example.montraexpensetracker.domain.UserModel

class AuthRepositoryImpl(private val authDataSource: FirebaseAuthDataSource) : AuthRepository {
    override suspend fun signUp(name: String, email: String, password: String): UserModel? {
        return authDataSource.signUp(name, email, password)
    }
}