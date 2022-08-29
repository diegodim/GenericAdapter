package com.example.pocadapter2

import android.view.View
import com.example.pocadapter2.databinding.ItemHeaderBinding
import com.example.pocadapter2.genericadapter.GenericItemViewBinding

class Header(private val text: String): GenericItemViewBinding<ItemHeaderBinding>() {

    override val layoutId: Int
        get() = R.layout.item_header

    override fun bind(binding: ItemHeaderBinding) {
        binding.textView.text = text
    }

    override fun setupViewBinding(view: View): ItemHeaderBinding = ItemHeaderBinding.bind(view)
}
