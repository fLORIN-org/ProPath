package com.propath.app.ui.progress

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.propath.app.data.local.AppDatabase
import com.propath.app.data.repository.ProgressRepository
import com.propath.app.data.repository.UserRepository
import com.propath.app.databinding.FragmentProgressBinding

/**
 * Экран прогресса — добавление матчей и просмотр истории.
 */
class ProgressFragment : Fragment() {

    private var _binding: FragmentProgressBinding? = null
    private val binding get() = _binding!!

    private val db by lazy { AppDatabase.getInstance(requireContext()) }
    private val userRepo by lazy { UserRepository(db.userDao(), requireContext()) }
    private val progressRepo by lazy { ProgressRepository(db.matchResultDao()) }

    private val viewModel: ProgressViewModel by viewModels {
        ProgressViewModelFactory(userRepo, progressRepo)
    }

    private lateinit var adapter: MatchAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentProgressBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Настраиваем RecyclerView
        adapter = MatchAdapter()
        binding.rvMatches.layoutManager = LinearLayoutManager(requireContext())
        binding.rvMatches.adapter = adapter

        viewModel.init()

        // Список матчей обновляется автоматически через LiveData
        viewModel.matches.observe(viewLifecycleOwner) { matches ->
            adapter.submitList(matches)
            binding.tvEmptyProgress.visibility = if (matches.isEmpty()) View.VISIBLE else View.GONE
        }

        // Результат сохранения
        viewModel.saveResult.observe(viewLifecycleOwner) { success ->
            if (success) {
                Snackbar.make(binding.root, "Результат сохранён!", Snackbar.LENGTH_SHORT).show()
                clearForm()
            }
        }

        viewModel.errorMessage.observe(viewLifecycleOwner) { msg ->
            Snackbar.make(binding.root, msg, Snackbar.LENGTH_SHORT).show()
        }

        // Кнопка сохранить
        binding.btnSaveResult.setOnClickListener {
            val isWin = binding.rbWin.isChecked
            val kills = binding.etKills.text.toString()
            val deaths = binding.etDeaths.text.toString()
            viewModel.saveMatch(isWin, kills, deaths)
        }
    }

    private fun clearForm() {
        binding.etKills.text?.clear()
        binding.etDeaths.text?.clear()
        binding.rbWin.isChecked = true
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
