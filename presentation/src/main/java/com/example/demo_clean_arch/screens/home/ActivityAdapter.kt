package com.example.demo_clean_arch.screens.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.demo_clean_arch.R
import com.example.demo_clean_arch.base.BaseDiffCallBack
import com.example.demo_clean_arch.base.BaseViewHolder
import com.example.demo_clean_arch.base.ItemClickListener
import com.example.demo_clean_arch.databinding.ItemRandomActivityBinding
import com.example.demo_clean_arch.model.ActivityModel
import javax.inject.Inject

class ActivityAdapter @Inject constructor() :
    ListAdapter<ActivityModel, ActivityViewHolder>(ActivityDiffCallback()) {

    var clickListener: ItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
        val itemBinding =
            DataBindingUtil.inflate<ItemRandomActivityBinding>(
                LayoutInflater.from(parent.context),
                R.layout.item_random_activity,
                parent,
                false
            )
        return ActivityViewHolder(itemBinding, clickListener)
    }

    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        holder.displayData(getItem(position), position)
    }
}

class ActivityViewHolder(
    private val itemBinding: ItemRandomActivityBinding,
    private val clickListener: ItemClickListener?
) :
    BaseViewHolder<ActivityModel>(itemBinding) {

    override fun displayData(entity: ActivityModel, position: Int) {
        itemBinding.apply {
            this.activity = entity
            this.clickListener = this@ActivityViewHolder.clickListener
            this.position = position
        }
    }
}

class ActivityDiffCallback : BaseDiffCallBack<ActivityModel>()
