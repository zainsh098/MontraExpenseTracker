package com.example.montraexpensetracker.domain

interface AuthRepository {

    suspend fun signUp(name: String, email: String, password: String): UserModel?

}