package com.propath.app.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.propath.app.data.repository.UserRepository

/**
 * Фабрика для создания LoginViewModel с зависимостями.
 * Нужна потому что ViewModelProvider не умеет передавать параметры конструктора.
 */
class LoginViewModelFactory(private val userRepository: UserRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return LoginViewModel(userRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}
