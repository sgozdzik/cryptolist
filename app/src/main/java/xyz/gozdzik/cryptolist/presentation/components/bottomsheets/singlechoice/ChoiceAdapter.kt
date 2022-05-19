package xyz.gozdzik.cryptolist.presentation.components.bottomsheets.singlechoice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import xyz.gozdzik.cryptolist.databinding.ItemSingleChoiceBinding

class ChoiceAdapter<T : Enum<T>> :
    ListAdapter<SingleChoiceItem<T>, SingleChoiceViewHolder>(DiffItemCallback()) {

    private var checkedPosition = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleChoiceViewHolder =
        SingleChoiceViewHolder(
            ItemSingleChoiceBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ) { itemPosition ->
            checkedPosition = itemPosition
            notifyDataSetChanged()
        }

    override fun onBindViewHolder(holder: SingleChoiceViewHolder, position: Int) =
        holder.bind(getItem(position), checkedPosition)

    class DiffItemCallback<T : Enum<T>> : DiffUtil.ItemCallback<SingleChoiceItem<T>>() {
        override fun areItemsTheSame(
            oldItem: SingleChoiceItem<T>,
            newItem: SingleChoiceItem<T>
        ): Boolean = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: SingleChoiceItem<T>,
            newItem: SingleChoiceItem<T>
        ): Boolean = oldItem.enum == newItem.enum
    }

}

class SingleChoiceViewHolder(
    private val binding: ItemSingleChoiceBinding,
    private val clickListener: (Int) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {

    init {
        binding.root.setOnClickListener {
            clickListener.invoke(adapterPosition)
        }
    }

    fun <T : Enum<T>> bind(singleChoiceItem: SingleChoiceItem<T>, checkedPosition: Int) {
        binding.item = singleChoiceItem
        binding.rbChoice.isChecked = adapterPosition == checkedPosition
    }

}