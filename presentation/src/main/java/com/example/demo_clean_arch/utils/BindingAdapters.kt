package com.example.demo_clean_arch.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.shared.Constants

class BindingAdapters {

    companion object {
        @JvmStatic
        @BindingAdapter("app:imageUrl")
        fun loadImage(
            view: ImageView,
            url: String
        ) {
            Glide.with(view.context).load(Constants.baseImageUrl + url).into(view)
        }

        @JvmStatic
        @BindingAdapter("app:goneUnless")
        fun goneUnless(view: View, visible: Boolean?) {
            view.visibility = if (visible == true) View.VISIBLE else View.GONE
        }
    }
}

