package com.propath.app.data.repository

import androidx.lifecycle.LiveData
import com.propath.app.data.local.MatchResultDao
import com.propath.app.data.model.MatchResult

/**
 * Репозиторий для работы с результатами матчей.
 * Слой Data в архитектуре MVVM.
 * ViewModel не знает, откуда данные — из БД или сети.
 */
class ProgressRepository(private val dao: MatchResultDao) {

    // Получить список матчей (LiveData — автообновление UI)
    fun getMatches(userId: Int): LiveData<List<MatchResult>> {
        return dao.getMatchesByUser(userId)
    }

    // Сохранить результат нового матча
    suspend fun saveMatch(match: MatchResult) {
        dao.insertMatch(match)
    }

    // Получить количество матчей (для статистики)
    suspend fun getMatchCount(userId: Int): Int {
        return dao.getMatchCount(userId)
    }

    // Получить количество побед
    suspend fun getWinCount(userId: Int): Int {
        return dao.getWinCount(userId)
    }

    // Вычислить Winrate в процентах
    suspend fun getWinrate(userId: Int): Int {
        val total = getMatchCount(userId)
        if (total == 0) return 0
        val wins = getWinCount(userId)
        return (wins * 100) / total
    }
}
