package com.propath.app.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.propath.app.data.model.MatchResult
import com.propath.app.data.model.User

/**
 * Главный класс базы данных Room.
 * Singleton — один экземпляр на всё приложение.
 */
@Database(entities = [User::class, MatchResult::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun matchResultDao(): MatchResultDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "propath_database"
                ).build().also { INSTANCE = it }
            }
        }
    }
}
