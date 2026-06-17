package com.propath.app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Модель пользователя.
 * Сохраняется в Room (локальная БД на устройстве).
 */
@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val email: String,
    val username: String,
    val game: String = "CS2",  // Игровая дисциплина
    val rank: String = "Silver"
)
