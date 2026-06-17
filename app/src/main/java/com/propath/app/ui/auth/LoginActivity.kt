package com.propath.app.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.propath.app.data.local.AppDatabase
import com.propath.app.data.repository.UserRepository
import com.propath.app.databinding.ActivityLoginBinding
import com.propath.app.ui.main.MainActivity
import com.propath.app.ui.onboarding.OnboardingActivity

/**
 * Экран входа.
 * MVVM: Activity управляет только UI,
 * вся логика — в LoginViewModel.
 */
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val db by lazy { AppDatabase.getInstance(this) }
    private val userRepo by lazy { UserRepository(db.userDao(), this) }
    private val viewModel: LoginViewModel by viewModels {
        LoginViewModelFactory(userRepo)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Если пользователь уже залогинен — пропускаем экран входа
        if (userRepo.getCurrentUserId() != -1) {
            goToMain()
            return
        }

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupObservers()
        setupClickListeners()
    }

    private fun setupObservers() {
        // Наблюдаем за результатом входа
        viewModel.loginResult.observe(this) { success ->
            if (success == true) {
                // Если онбординг ещё не показывался — показываем
                if (!userRepo.isOnboardingShown()) {
                    startActivity(Intent(this, OnboardingActivity::class.java))
                } else {
                    goToMain()
                }
                finish()
            }
        }

        // Показываем ошибку через Snackbar
        viewModel.errorMessage.observe(this) { message ->
            Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun setupClickListeners() {
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString()
            viewModel.login(email, password)
        }

        // Регистрация: создаём пользователя с теми же данными (в учебном проекте)
        binding.btnRegister.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString()
            viewModel.login(email, password)  // Упрощённо: регистрация = вход
        }
    }

    private fun goToMain() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
