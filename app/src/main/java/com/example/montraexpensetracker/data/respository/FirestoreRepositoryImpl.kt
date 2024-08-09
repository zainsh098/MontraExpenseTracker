package com.example.montraexpensetracker.data.respository

import com.example.montraexpensetracker.data.remote.FirebaseFirestoreDataSource
import com.example.montraexpensetracker.domain.FirestoreRepository
import com.example.montraexpensetracker.domain.UserModel

class FirestoreRepositoryImpl(private val firestoreDataSource: FirebaseFirestoreDataSource) :
    FirestoreRepository {
    override suspend fun saveUser(userModel: UserModel) {
        firestoreDataSource.saveUser(userModel)
    }
}
