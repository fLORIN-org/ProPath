package com.propath.app.ui.onboarding

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.propath.app.R
import com.propath.app.data.local.AppDatabase
import com.propath.app.data.repository.UserRepository
import com.propath.app.databinding.ActivityOnboardingBinding
import com.propath.app.ui.main.MainActivity

/**
 * Экран онбординга — показывается только при первом запуске.
 * 3 слайда, переключение кнопкой Далее.
 */
class OnboardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingBinding
    private val userRepo by lazy {
        UserRepository(AppDatabase.getInstance(this).userDao(), this)
    }

    // Данные слайдов (иконка, заголовок, описание)
    private val slides = listOf(
        Triple("🎮", "Трекай прогресс", "Записывай результаты матчей и отслеживай свой рост в реальном времени"),
        Triple("🏆", "Найди тренера", "Маркетплейс профессиональных тренеров по твоей дисциплине"),
        Triple("⚔️", "Участвуй в турнирах", "Каталог ближайших турниров с фильтром по уровню")
    )

    private var currentPage = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupDots()
        showSlide(0)

        binding.btnOnboardingNext.setOnClickListener {
            if (currentPage < slides.size - 1) {
                currentPage++
                showSlide(currentPage)
            } else {
                // Последний слайд — помечаем онбординг показанным и переходим в приложение
                userRepo.markOnboardingShown()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
    }

    private fun showSlide(index: Int) {
        val (icon, title, desc) = slides[index]
        binding.tvOnboardingIcon.text = icon
        binding.tvOnboardingTitle.text = title
        binding.tvOnboardingDesc.text = desc

        // Обновляем индикаторы
        for (i in 0 until binding.llDots.childCount) {
            val dot = binding.llDots.getChildAt(i) as TextView
            dot.alpha = if (i == index) 1f else 0.3f
        }

        // На последнем слайде меняем текст кнопки
        binding.btnOnboardingNext.text = if (index == slides.size - 1) "Начать" else "Далее"
    }

    private fun setupDots() {
        binding.llDots.removeAllViews()
        for (i in slides.indices) {
            val dot = TextView(this).apply {
                text = "●"
                textSize = 16f
                setTextColor(getColor(R.color.colorPrimary))
                alpha = if (i == 0) 1f else 0.3f
                setPadding(8, 0, 8, 0)
            }
            binding.llDots.addView(dot)
        }
    }
}
