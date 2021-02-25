package com.anuar81.lucasscamp.data

import android.content.Context
import com.anuar81.lucasscamp.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginRepository(context: Context) {

    // Generamos la configuración
    val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestIdToken(context.getString(R.string.default_web_client_id))
        .requestEmail()
        .build()

    val repositoryClient = GoogleSignIn.getClient(context, gso)

    var repositoryAuth: FirebaseAuth = Firebase.auth
}