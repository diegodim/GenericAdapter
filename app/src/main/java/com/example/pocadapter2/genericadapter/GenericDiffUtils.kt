package com.example.pocadapter2.genericadapter

import androidx.recyclerview.widget.DiffUtil

internal object GenericDiffUtils : DiffUtil.ItemCallback<GenericItem>() {

    override fun areItemsTheSame(oldItem: GenericItem, newItem: GenericItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: GenericItem, newItem: GenericItem): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }
}
