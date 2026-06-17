package com.propath.app.ui.progress

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.propath.app.data.repository.ProgressRepository
import com.propath.app.data.repository.UserRepository

class ProgressViewModelFactory(
    private val userRepo: UserRepository,
    private val progressRepo: ProgressRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProgressViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ProgressViewModel(userRepo, progressRepo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}
