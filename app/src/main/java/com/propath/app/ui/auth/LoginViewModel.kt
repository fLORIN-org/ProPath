package com.propath.app.ui.auth

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.propath.app.data.model.User
import com.propath.app.data.repository.UserRepository
import kotlinx.coroutines.launch

/**
 * ViewModel для экрана входа.
 * Проверяет поля и сохраняет пользователя.
 */
class LoginViewModel(private val userRepository: UserRepository) : ViewModel() {

    // Состояние входа: null = ничего, true = успех, false = ошибка
    val loginResult = MutableLiveData<Boolean?>()
    val errorMessage = MutableLiveData<String>()

    fun login(email: String, password: String) {
        // Валидация email
        if (email.isBlank()) {
            errorMessage.value = "Введи email"
            return
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            errorMessage.value = "Некорректный email"
            return
        }
        // Валидация пароля
        if (password.isBlank()) {
            errorMessage.value = "Введи пароль"
            return
        }
        if (password.length < 6) {
            errorMessage.value = "Минимум 6 символов"
            return
        }

        // Сохраняем пользователя (в учебном проекте — без реального сервера)
        viewModelScope.launch {
            try {
                val user = User(
                    email = email,
                    username = email.substringBefore("@")
                )
                userRepository.saveUser(user)
                loginResult.value = true
            } catch (e: Exception) {
                errorMessage.value = "Ошибка входа"
                loginResult.value = false
            }
        }
    }
}
