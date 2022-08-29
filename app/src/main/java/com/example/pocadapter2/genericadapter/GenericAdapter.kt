package com.example.pocadapter2.genericadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.viewbinding.ViewBinding
import com.example.pocadapter2.genericadapter.exception.InvalidCastException
import com.example.pocadapter2.genericadapter.exception.NotFoundViewTypeException

class GenericAdapter(onClickItem: (item: GenericItem) -> Unit = {}) :
    GenAdapter<GenericViewHolder<ViewBinding>>(onClickItem)

open class GenAdapter<VH : GenericViewHolder<ViewBinding>>(
    private val onClickItem: (item: GenericItem) -> Unit = {}
) : ListAdapter<GenericItem, VH>(GenericDiffUtils) {

    private var lastItemType: GenericItemViewBinding<ViewBinding>? = null

    @Suppress("UNCHECKED_CAST")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val item: GenericItemViewBinding<ViewBinding> = getItemByType(viewType)
        val itemView: View =
            LayoutInflater.from(parent.context).inflate(item.layoutId, parent, false)
        return item.createViewHolder(itemView) as? VH ?: throw InvalidCastException()
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        getItem(position).toGenericItem()?.bind(holder, position, onClickItem)
    }

    override fun getItemViewType(position: Int): Int = getItem(position).getViewType()

    private fun getItemByType(viewType: Int): GenericItemViewBinding<ViewBinding> {
        lastItemType?.let { lastItem ->
            if (lastItem.getViewType() == viewType) {
                return lastItem
            }
        }
        this.currentList.firstOrNull { item ->
            item.getViewType() == viewType
        }?.toGenericItem()?.let { foundItem ->
            lastItemType = foundItem
            return foundItem
        }
        throw NotFoundViewTypeException(viewType)
    }
}
