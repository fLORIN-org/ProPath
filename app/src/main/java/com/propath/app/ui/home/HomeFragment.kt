package com.propath.app.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.propath.app.R
import com.propath.app.data.local.AppDatabase
import com.propath.app.data.repository.ProgressRepository
import com.propath.app.data.repository.UserRepository
import com.propath.app.databinding.FragmentHomeBinding

/**
 * Главный экран — дашборд с приветствием и статистикой.
 */
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val db by lazy { AppDatabase.getInstance(requireContext()) }
    private val userRepo by lazy { UserRepository(db.userDao(), requireContext()) }
    private val progressRepo by lazy { ProgressRepository(db.matchResultDao()) }

    private val viewModel: HomeViewModel by viewModels {
        HomeViewModelFactory(userRepo, progressRepo)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Наблюдаем за данными
        viewModel.currentUser.observe(viewLifecycleOwner) { user ->
            binding.tvGreeting.text = "Привет, ${user?.username ?: "Игрок"}!"
        }

        viewModel.totalMatches.observe(viewLifecycleOwner) { count ->
            binding.tvTotalMatches.text = count.toString()
        }

        viewModel.winrate.observe(viewLifecycleOwner) { wr ->
            binding.tvWinrate.text = "$wr%"
        }

        // Кнопка добавить матч — переходим на экран прогресса
        binding.btnAddMatch.setOnClickListener {
            findNavController().navigate(R.id.progressFragment)
        }

        viewModel.loadData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
