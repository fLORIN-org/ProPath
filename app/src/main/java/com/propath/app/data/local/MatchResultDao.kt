package com.propath.app.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.propath.app.data.model.MatchResult

/**
 * DAO для работы с таблицей match_results.
 * LiveData автоматически обновляет UI при изменении данных.
 */
@Dao
interface MatchResultDao {

    // Получить все матчи пользователя (сортировка: новые сверху)
    @Query("SELECT * FROM match_results WHERE userId = :userId ORDER BY timestamp DESC")
    fun getMatchesByUser(userId: Int): LiveData<List<MatchResult>>

    // Подсчёт количества матчей
    @Query("SELECT COUNT(*) FROM match_results WHERE userId = :userId")
    suspend fun getMatchCount(userId: Int): Int

    // Количество побед
    @Query("SELECT COUNT(*) FROM match_results WHERE userId = :userId AND isWin = 1")
    suspend fun getWinCount(userId: Int): Int

    // Сохранить результат матча
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMatch(match: MatchResult)

    // Удалить все матчи пользователя
    @Query("DELETE FROM match_results WHERE userId = :userId")
    suspend fun deleteAllMatches(userId: Int)
}
