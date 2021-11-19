package com.example.demo_clean_arch.screens.home.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.demo_clean_arch.R
import com.example.demo_clean_arch.base.BaseDataBindingFragment
import com.example.demo_clean_arch.databinding.FragmentDetailBinding
import com.example.demo_clean_arch.model.ActivityModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailFragment : BaseDataBindingFragment<FragmentDetailBinding>(),
    DetailNavigator {

    override val layoutResource: Int
        get() = R.layout.fragment_detail

    private val viewModel: DetailViewModel by viewModels()

    private val model by lazy {
        ActivityModel(
            id = arguments?.getInt("id"),
            accessibility = arguments?.getDouble("accessibility"),
            activity = arguments?.getString("activity"),
            key = arguments?.getString("key"),
            link = arguments?.getString("link"),
            participants = arguments?.getInt("participants"),
            price = arguments?.getDouble("price"),
            type = arguments?.getString("type"),
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.activity = model
    }

    override fun initOnCreateView() {

    }

    override fun goBack() {
        findNavController().popBackStack()
    }
}
