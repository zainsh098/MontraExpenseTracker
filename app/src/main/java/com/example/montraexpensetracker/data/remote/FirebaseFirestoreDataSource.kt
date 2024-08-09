package com.example.montraexpensetracker.data.remote

import com.example.montraexpensetracker.domain.FirestoreRepository
import com.example.montraexpensetracker.domain.UserModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class FirebaseFirestoreDataSource : FirestoreRepository {
    private val firestore = FirebaseFirestore.getInstance()

    override suspend fun saveUser(userModel: UserModel) {
        firestore.collection("users").document(userModel.id).set(userModel).await()
    }
}
