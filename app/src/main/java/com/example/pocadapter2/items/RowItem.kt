package com.example.pocadapter2.items

import android.view.View
import com.example.pocadapter2.R
import com.example.pocadapter2.databinding.ItemRowBinding
import com.example.pocadapter2.genericadapter.GenericItemViewBinding

class RowItem(val name: String): GenericItemViewBinding<ItemRowBinding>() {

    override val layoutId: Int
        get() = R.layout.item_row

    override fun bind(binding: ItemRowBinding) {
        binding.tvName.text = name
    }

    override fun setupViewBinding(view: View): ItemRowBinding = ItemRowBinding.bind(view)
}
