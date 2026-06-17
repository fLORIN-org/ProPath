package com.propath.app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Результат одного матча.
 * isWin = true — победа, false — поражение.
 * kills, deaths — статистика за матч.
 */
@Entity(tableName = "match_results")
data class MatchResult(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val userId: Int,
    val isWin: Boolean,
    val kills: Int,
    val deaths: Int,
    val timestamp: Long = System.currentTimeMillis()
) {
    // Вычисляемое поле: K/D = убийства / смерти (избегаем деление на 0)
    val kd: Float get() = if (deaths > 0) kills.toFloat() / deaths else kills.toFloat()
}
