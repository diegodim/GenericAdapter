package com.example.pocadapter2.items

import android.view.View
import com.bumptech.glide.Glide
import com.example.pocadapter2.R
import com.example.pocadapter2.databinding.ItemHeaderBinding
import com.example.pocadapter2.databinding.ItemImageBinding
import com.example.pocadapter2.genericadapter.GenericItem
import com.example.pocadapter2.genericadapter.GenericItemViewBinding

class ImageItem(private val image: String) : GenericItemViewBinding<ItemImageBinding>() {
    override val layoutId: Int
        get() = R.layout.item_image

    override fun bind(binding: ItemImageBinding, position: Int) {
        Glide.with(binding.root.context)
            .load(image)
            .into(binding.imvBanner)
    }

    override fun setupViewBinding(view: View): ItemImageBinding = ItemImageBinding.bind(view)

}
