package com.example.montraexpensetracker.data.remote

import com.example.montraexpensetracker.domain.AuthRepository
import com.example.montraexpensetracker.domain.UserModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await

class FirebaseAuthDataSource : AuthRepository {

    private val auth = FirebaseAuth.getInstance()
    override suspend fun signUp(name: String, email: String, password: String): UserModel? {
        val result = auth.createUserWithEmailAndPassword(email, password).await()
        val firebaseUser = result.user
        return firebaseUser?.let {
            UserModel(it.uid, name, email, password)

        }

    }


}