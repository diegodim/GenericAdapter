package com.example.pocadapter2.genericadapter

import android.view.View
import androidx.viewbinding.ViewBinding

abstract class GenericItemViewBinding<VB : ViewBinding> : GenericItem {

    override fun getViewType(): Int {
        return layoutId
    }

    open fun createViewHolder(itemView: View): GenericViewHolder<VB> {
        val binding: VB = setupViewBinding(itemView)
        return GenericViewHolder(binding)
    }

    @Suppress("UNCHECKED_CAST")
    override fun toGenericItem(): GenericItemViewBinding<ViewBinding>? =
        this as? GenericItemViewBinding<ViewBinding>

    fun bind(
        viewHolder: GenericViewHolder<VB>,
        position: Int,
        onClickItem: (item: GenericItemViewBinding<VB>) -> Unit
    ) {
        viewHolder.bind(this, position, onClickItem)
        bind(viewHolder.binding)
    }

    abstract val layoutId: Int

    abstract fun bind(binding: VB)

    abstract fun setupViewBinding(view: View): VB
}
