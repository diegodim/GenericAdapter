package com.example.pocadapter2.generiadapter

import androidx.viewbinding.ViewBinding

interface GenericItem {
    fun getViewType(): Int
    fun toGenericItem(): GenericItemViewBinding<ViewBinding>?
}
