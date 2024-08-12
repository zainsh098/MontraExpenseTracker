package com.example.montraexpensetracker.domain

data class UserModel(

    val id: String,
    val name: String,
    val email: String,
    val password: String,
)


data class UserLoginModel(
    val email: String,
    val password: String,
)


data class ForgotPasswordModel(
    val email: String,
)

