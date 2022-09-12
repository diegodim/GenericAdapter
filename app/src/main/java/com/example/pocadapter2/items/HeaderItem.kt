package com.example.pocadapter2.items

import android.view.View
import com.example.pocadapter2.R
import com.example.pocadapter2.databinding.ItemHeaderBinding
import com.example.pocadapter2.genericadapter.GenericItemViewBinding

class HeaderItem(private val text: String): GenericItemViewBinding<ItemHeaderBinding>() {

    override val layoutId: Int
        get() = R.layout.item_header

    override fun bind(binding: ItemHeaderBinding) {
        binding.tvTitle.text = text
    }

    override fun setupViewBinding(view: View): ItemHeaderBinding = ItemHeaderBinding.bind(view)
}
