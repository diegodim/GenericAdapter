package com.example.pocadapter2.genericadapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

open class GenericViewHolder<VB : ViewBinding>(val binding: VB) :
    RecyclerView.ViewHolder(binding.root) {
    private var item: GenericItemViewBinding<VB>? = null

    open fun bind(
        item: GenericItemViewBinding<VB>,
        position: Int,
        onClickItem: (item: GenericItemViewBinding<VB>) -> Unit
    ) {
        this.item = item
        itemView.setOnClickListener { onClickItem(item) }
    }
}
