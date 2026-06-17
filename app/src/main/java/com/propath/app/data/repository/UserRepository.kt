package com.propath.app.data.repository

import android.content.Context
import androidx.core.content.edit
import com.propath.app.data.local.UserDao
import com.propath.app.data.model.User

/**
 * Репозиторий пользователя.
 * Сохраняет текущего пользователя в SharedPreferences (id),
 * данные — в Room.
 */
class UserRepository(
    private val dao: UserDao,
    private val context: Context
) {
    private val prefs = context.getSharedPreferences("propath_prefs", Context.MODE_PRIVATE)

    // Сохранить пользователя и запомнить его id
    suspend fun saveUser(user: User): Int {
        val id = dao.insertUser(user).toInt()
        prefs.edit { putInt("current_user_id", id) }
        return id
    }

    // Получить id текущего пользователя (или -1 если не залогинен)
    fun getCurrentUserId(): Int {
        return prefs.getInt("current_user_id", -1)
    }

    // Загрузить данные пользователя по id
    suspend fun getCurrentUser(): User? {
        val id = getCurrentUserId()
        return if (id != -1) dao.getUserById(id) else null
    }

    // Выйти из аккаунта
    fun logout() {
        prefs.edit { remove("current_user_id") }
    }

    // Показывался ли онбординг
    fun isOnboardingShown(): Boolean {
        return prefs.getBoolean("onboarding_shown", false)
    }

    fun markOnboardingShown() {
        prefs.edit { putBoolean("onboarding_shown", true) }
    }
}
