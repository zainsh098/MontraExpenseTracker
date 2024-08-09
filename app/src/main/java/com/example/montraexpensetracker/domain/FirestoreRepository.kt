package com.example.montraexpensetracker.domain

interface FirestoreRepository {

    suspend fun saveUser(userModel: UserModel)

}