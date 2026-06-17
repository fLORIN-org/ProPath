package com.propath.app.ui.progress

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.propath.app.data.model.MatchResult
import com.propath.app.data.repository.ProgressRepository
import com.propath.app.data.repository.UserRepository
import kotlinx.coroutines.launch

/**
 * ViewModel экрана прогресса.
 * Отдаёт список матчей и сохраняет новые результаты.
 */
class ProgressViewModel(
    private val userRepository: UserRepository,
    private val progressRepository: ProgressRepository
) : ViewModel() {

    private val _userId = MutableLiveData<Int>()
    val saveResult = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String>()

    lateinit var matches: LiveData<List<MatchResult>>

    fun init() {
        viewModelScope.launch {
            val userId = userRepository.getCurrentUserId()
            _userId.value = userId
            matches = progressRepository.getMatches(userId)
        }
    }

    fun saveMatch(isWin: Boolean, killsStr: String, deathsStr: String) {
        val kills = killsStr.toIntOrNull()
        val deaths = deathsStr.toIntOrNull()

        if (kills == null || kills < 0) {
            errorMessage.value = "Введи корректное число убийств"
            return
        }
        if (deaths == null || deaths < 0) {
            errorMessage.value = "Введи корректное число смертей"
            return
        }

        viewModelScope.launch {
            val userId = userRepository.getCurrentUserId()
            val match = MatchResult(
                userId = userId,
                isWin = isWin,
                kills = kills,
                deaths = deaths
            )
            progressRepository.saveMatch(match)
            saveResult.value = true
        }
    }
}
