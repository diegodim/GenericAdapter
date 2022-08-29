package com.example.pocadapter2

import android.view.View
import com.example.pocadapter2.databinding.ItemRowBinding
import com.example.pocadapter2.generiadapter.GenericItemViewBinding

class Row(val text: String): GenericItemViewBinding<ItemRowBinding>() {

    override val layoutId: Int
        get() = R.layout.item_row

    override fun bind(binding: ItemRowBinding) {
        binding.textView2.text = text
    }

    override fun setupViewBinding(view: View): ItemRowBinding = ItemRowBinding.bind(view)
}
