package com.anuar81.lucasscamp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anuar81.lucasscamp.data.LoginRepository
import com.anuar81.lucasscamp.data.ServiceDBRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val loginRepository: LoginRepository, private val serviceDBRepository: ServiceDBRepository) : ViewModel() {
    // TODO: Implement the ViewModel
    private var _updateView: MutableLiveData<Boolean> = MutableLiveData()
    val updateView:LiveData<Boolean> = _updateView

    var auth: FirebaseAuth = loginRepository.repositoryAuth

    fun loadOrCreateUserData() = viewModelScope.launch {
        var userExist = serviceDBRepository.checkifUserExist(auth)
        if (!userExist) {
            serviceDBRepository.addNewUser(auth)
        }
        launch (Dispatchers.Main) {
            _updateView.value = true
        }
    }
}