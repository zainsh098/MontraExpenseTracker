package com.example.montraexpensetracker.domain

interface AuthRepository {

    suspend fun signUp(name: String, email: String, password: String): UserModel?
    suspend fun loginUser(email: String, password: String):UserLoginModel?
    suspend fun userForgotPassword(email: String):ForgotPasswordModel?

}