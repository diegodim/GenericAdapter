package com.example.pocadapter2.genericadapter

import androidx.viewbinding.ViewBinding

interface GenericItem {
    fun getViewType(): Int
    fun toGenericItem(): GenericItemViewBinding<ViewBinding>?
}
