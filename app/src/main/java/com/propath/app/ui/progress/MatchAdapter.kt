package com.propath.app.ui.progress

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.propath.app.R
import com.propath.app.data.model.MatchResult
import com.propath.app.databinding.ItemMatchBinding
import java.text.SimpleDateFormat
import java.util.*

/**
 * Адаптер для списка матчей.
 * ListAdapter + DiffUtil — эффективное обновление только изменившихся элементов.
 */
class MatchAdapter : ListAdapter<MatchResult, MatchAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMatchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: ItemMatchBinding) : RecyclerView.ViewHolder(binding.root) {

        private val dateFormat = SimpleDateFormat("dd MMM, HH:mm", Locale("ru"))

        fun bind(match: MatchResult) {
            // Победа / Поражение
            binding.tvMatchResult.text = if (match.isWin) "W" else "L"
            binding.tvMatchResult.setBackgroundResource(
                if (match.isWin) R.drawable.bg_result_badge else R.drawable.bg_result_loss
            )

            // K/D: "12/5 (K/D: 2.4)"
            binding.tvMatchKd.text = "${match.kills}/${match.deaths}  ·  K/D: ${"%.1f".format(match.kd)}"

            // Дата
            binding.tvMatchDate.text = dateFormat.format(Date(match.timestamp))
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<MatchResult>() {
        override fun areItemsTheSame(oldItem: MatchResult, newItem: MatchResult) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: MatchResult, newItem: MatchResult) = oldItem == newItem
    }
}
