package com.example.pocadapter2.items

import android.view.View
import com.example.pocadapter2.R
import com.example.pocadapter2.databinding.ItemHeaderBinding
import com.example.pocadapter2.genericadapter.GenericItemViewBinding

class HeaderItem(private val title: String) : GenericItemViewBinding<ItemHeaderBinding>() {

    override val layoutId: Int
        get() = R.layout.item_header

    override fun bind(binding: ItemHeaderBinding, position: Int) {
        binding.tvTitle.text = title
    }

    override fun setupViewBinding(view: View): ItemHeaderBinding = ItemHeaderBinding.bind(view)

}
