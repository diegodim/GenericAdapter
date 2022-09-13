package com.example.pocadapter2.items

import android.view.View
import com.example.pocadapter2.R
import com.example.pocadapter2.databinding.ItemHeaderBinding
import com.example.pocadapter2.databinding.ItemRowBinding
import com.example.pocadapter2.genericadapter.GenericItem
import com.example.pocadapter2.genericadapter.GenericItemViewBinding

class RowItem(private val name: String, val onClick: (String) -> Unit) :
    GenericItemViewBinding<ItemRowBinding>() {

    override val layoutId: Int
        get() = R.layout.item_row

    override fun bind(binding: ItemRowBinding, position: Int) {
        binding.tvName.text = name
    }

    override fun setupViewBinding(view: View): ItemRowBinding = ItemRowBinding.bind(view)

    override fun onClickItem() {
        onClick(name)
    }
}
