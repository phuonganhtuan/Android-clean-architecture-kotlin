package com.example.demo_clean_arch.base

import androidx.recyclerview.widget.DiffUtil
import com.example.demo_clean_arch.model.PresentationModel

abstract class BaseDiffCallBack<T> : DiffUtil.ItemCallback<T>() {

    override fun areContentsTheSame(oldItem: T, newItem: T) =
        (oldItem as PresentationModel).id == (newItem as PresentationModel).id

    override fun areItemsTheSame(oldItem: T, newItem: T) = oldItem === newItem
}
