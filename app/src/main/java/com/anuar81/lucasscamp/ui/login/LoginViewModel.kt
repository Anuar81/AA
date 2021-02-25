package com.anuar81.lucasscamp.ui.login

import androidx.lifecycle.ViewModel
import com.anuar81.lucasscamp.data.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginRepository: LoginRepository) : ViewModel() {
    // TODO: Implement the ViewModel
    val client = loginRepository.repositoryClient
    var auth = loginRepository.repositoryAuth
}