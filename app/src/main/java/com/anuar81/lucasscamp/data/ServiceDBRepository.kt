package com.anuar81.lucasscamp.data

import com.anuar81.lucasscamp.domain.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

class ServiceDBRepository {
    companion object {
        private const val USER_COLLECTION_KEY = "users"
    }

    val firebaseDB = Firebase.firestore
    val userCollection = firebaseDB.collection(USER_COLLECTION_KEY)

    suspend fun checkifUserExist(auth: FirebaseAuth) = checkUser(auth)

    suspend fun addNewUser(auth: FirebaseAuth) {
        addNewUserToDB(auth)
    }

    private suspend fun checkUser(auth: FirebaseAuth): Boolean {
        var result = false
        userCollection
            .get()
            .addOnSuccessListener {
                for (document in it) {
                    if(document.id.equals(auth.uid)) {
                        result = true
                    }
                }
            }
            .addOnFailureListener {
                result = false
            }.await()
        return result
    }

    private suspend fun addNewUserToDB(auth: FirebaseAuth) {
        val user = User(auth.uid!!, auth.currentUser!!.displayName!!)
        userCollection.document(user.uid).set(user)
    }
}