package com.example.demo_clean_arch.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import java.text.FieldPosition

abstract class BaseViewHolder<T>(itemViewBinding: ViewBinding) :
    RecyclerView.ViewHolder(itemViewBinding.root) {

    abstract fun displayData(entity: T, position: Int)
}
