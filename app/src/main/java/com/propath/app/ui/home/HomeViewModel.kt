package com.propath.app.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.propath.app.data.model.User
import com.propath.app.data.repository.ProgressRepository
import com.propath.app.data.repository.UserRepository
import kotlinx.coroutines.launch

/**
 * ViewModel главного экрана.
 * Загружает данные пользователя и статистику за неделю.
 */
class HomeViewModel(
    private val userRepository: UserRepository,
    private val progressRepository: ProgressRepository
) : ViewModel() {

    val currentUser = MutableLiveData<User?>()
    val totalMatches = MutableLiveData<Int>()
    val winrate = MutableLiveData<Int>()
    val avgKd = MutableLiveData<Float>()

    fun loadData() {
        viewModelScope.launch {
            // Загружаем пользователя
            val user = userRepository.getCurrentUser()
            currentUser.value = user

            user?.let {
                // Загружаем статистику
                totalMatches.value = progressRepository.getMatchCount(it.id)
                winrate.value = progressRepository.getWinrate(it.id)
            }
        }
    }
}
