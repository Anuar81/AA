package com.anuar81.lucasscamp.ui.login

import android.content.Intent
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.anuar81.lucasscamp.data.LoginRepository
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginRepository: LoginRepository) : ViewModel() {
    // TODO: Implement the ViewModel
    val client = loginRepository.repositoryClient
    var auth = loginRepository.repositoryAuth
    private var _launchNextFragment: MutableLiveData<FirebaseUser?> = MutableLiveData()
    val launchNextFragment: LiveData<FirebaseUser?> = _launchNextFragment

    fun checkGoogleAuthFB(data: Intent?) {
        loginRepository.authWithGoogleSing(data)
        loginRepository.loginStatus.observeForever(Observer {
            _launchNextFragment.value = it
        })
    }


}