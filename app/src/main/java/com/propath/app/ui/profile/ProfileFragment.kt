package com.propath.app.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.propath.app.data.local.AppDatabase
import com.propath.app.data.repository.ProgressRepository
import com.propath.app.data.repository.UserRepository
import com.propath.app.databinding.FragmentProfileBinding
import com.propath.app.ui.auth.LoginActivity
import kotlinx.coroutines.launch

/**
 * Экран профиля — данные пользователя и кнопка выхода.
 */
class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private val db by lazy { AppDatabase.getInstance(requireContext()) }
    private val userRepo by lazy { UserRepository(db.userDao(), requireContext()) }
    private val progressRepo by lazy { ProgressRepository(db.matchResultDao()) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadProfile()

        binding.btnLogout.setOnClickListener {
            userRepo.logout()
            startActivity(Intent(requireContext(), LoginActivity::class.java))
            requireActivity().finish()
        }
    }

    private fun loadProfile() {
        lifecycleScope.launch {
            val user = userRepo.getCurrentUser()
            user?.let {
                binding.tvUsername.text = it.username
                binding.tvGameTag.text = it.game
                binding.tvAvatarLetter.text = it.username.firstOrNull()?.uppercase() ?: "P"

                val total = progressRepo.getMatchCount(it.id)
                val wr = progressRepo.getWinrate(it.id)
                binding.tvProfileMatches.text = total.toString()
                binding.tvProfileWinrate.text = "$wr%"
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
