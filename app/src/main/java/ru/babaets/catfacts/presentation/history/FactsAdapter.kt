package ru.babaets.catfacts.presentation.history

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.babaets.catfacts.common.formatApiDateTime
import ru.babaets.catfacts.data.model.Fact
import ru.babaets.catfacts.databinding.ViewItemFactBinding

class FactsAdapter : ListAdapter<Fact, FactsAdapter.ViewHolder>(FactsDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewItemFactBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            .let {
                ViewHolder(it)
            }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: ViewItemFactBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private val context: Context
            get() = itemView.context

        fun bind(item: Fact) {
            binding.run {
                tvFact.text = item.text
                tvUpdatedAt.text = item.updatedAt.formatApiDateTime(context)
            }
        }
    }

    class FactsDiffUtilCallback : DiffUtil.ItemCallback<Fact>() {

        override fun areItemsTheSame(oldItem: Fact, newItem: Fact): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Fact, newItem: Fact): Boolean =
            oldItem == newItem
    }
}
