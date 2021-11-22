package com.example.demo_clean_arch.screens.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.demo_clean_arch.R
import com.example.demo_clean_arch.base.BaseDiffCallBack
import com.example.demo_clean_arch.base.BaseViewHolder
import com.example.demo_clean_arch.base.ItemClickListener
import com.example.demo_clean_arch.databinding.ItemMovieHomeBinding
import com.example.demo_clean_arch.model.MovieSummaryModel
import javax.inject.Inject

class MovieSummaryAdapter @Inject constructor() :
    ListAdapter<MovieSummaryModel, MovieVH>(MovieDiffCallback()) {

    var clickListener: ItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieVH {
        val itemBinding =
            DataBindingUtil.inflate<ItemMovieHomeBinding>(
                LayoutInflater.from(parent.context),
                R.layout.item_movie_home,
                parent,
                false
            )
        return MovieVH(itemBinding, clickListener)
    }

    override fun onBindViewHolder(holder: MovieVH, position: Int) {
        holder.displayData(getItem(position), position)
    }
}

class MovieVH(
    private val itemBinding: ItemMovieHomeBinding,
    private val onClickListener: ItemClickListener?
) : BaseViewHolder<MovieSummaryModel>(itemBinding) {

    override fun displayData(entity: MovieSummaryModel, position: Int) {
        itemBinding.apply {
            clickListener = onClickListener
            this.position = position
            movie = entity
        }
    }
}

class MovieDiffCallback : BaseDiffCallBack<MovieSummaryModel>()
