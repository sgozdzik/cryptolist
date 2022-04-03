package xyz.gozdzik.cryptolist.presentation.currencylist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import xyz.gozdzik.cryptolist.databinding.ItemCurrencyInfoBinding
import xyz.gozdzik.cryptolist.presentation.model.CurrencyInfoItem

class CurrencyListAdapter(private val clickListener: (CurrencyInfoItem) -> Unit) :
    ListAdapter<CurrencyInfoItem, CurrencyItemViewHolder>(DiffItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyItemViewHolder =
        CurrencyItemViewHolder(
            ItemCurrencyInfoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ) { itemPosition ->
            clickListener.invoke(getItem(itemPosition))
        }

    override fun onBindViewHolder(holder: CurrencyItemViewHolder, position: Int) =
        holder.bind(getItem(position))

    object DiffItemCallback : DiffUtil.ItemCallback<CurrencyInfoItem>() {
        override fun areItemsTheSame(
            oldItem: CurrencyInfoItem,
            newItem: CurrencyInfoItem
        ): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: CurrencyInfoItem,
            newItem: CurrencyInfoItem
        ): Boolean = oldItem == newItem

    }
}

class CurrencyItemViewHolder(
    private val binding: ItemCurrencyInfoBinding,
    private val clickListener: (Int) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {

    init {
        binding.root.setOnClickListener {
            clickListener.invoke(adapterPosition)
        }
    }

    fun bind(currencyInfoItem: CurrencyInfoItem) {
        binding.item = currencyInfoItem
    }

}