package com.example.montraexpensetracker.data.respository

import com.example.montraexpensetracker.data.remote.FirebaseAuthDataSource
import com.example.montraexpensetracker.domain.AuthRepository
import com.example.montraexpensetracker.domain.ForgotPasswordModel
import com.example.montraexpensetracker.domain.UserLoginModel
import com.example.montraexpensetracker.domain.UserModel

class AuthRepositoryImpl(private val authDataSource: FirebaseAuthDataSource) : AuthRepository {
    override suspend fun signUp(name: String, email: String, password: String): UserModel? {
        return authDataSource.signUp(name, email, password)
    }

    override suspend fun loginUser(email: String, password: String): UserLoginModel? {

        return authDataSource.loginUser(email, password)

    }

    override suspend fun userForgotPassword(email: String): ForgotPasswordModel? {
        return authDataSource.userForgotPassword(email)
    }

}