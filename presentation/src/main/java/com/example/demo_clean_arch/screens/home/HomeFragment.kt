package com.example.demo_clean_arch.screens.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.demo_clean_arch.R
import com.example.demo_clean_arch.base.BaseDataBindingFragment
import com.example.demo_clean_arch.base.ItemClickListener
import com.example.demo_clean_arch.databinding.FragmentHomeBinding
import com.example.demo_clean_arch.model.MovieSummaryModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : BaseDataBindingFragment<FragmentHomeBinding>(), HomeNavigator,
    ItemClickListener {

    override val layoutResource: Int
        get() = R.layout.fragment_home

    private val viewModel: HomeViewModel by viewModels()

    @Inject
    lateinit var adapter: MovieSummaryAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initData()
        setupEvents()
        observeData()
    }

    override fun initOnCreateView() {

    }

    override fun toDetail(item: MovieSummaryModel) {
    }

    override fun goBack() {

    }

    override fun onItemClick(view: View?, position: Int) {
        toDetail(viewModel.trendingMovieList.value[position])
    }

    private fun initViews() = with(binding) {
        recyclerTrending.adapter = adapter
        adapter.clickListener = this@HomeFragment
    }

    private fun initData() = with(viewModel) {
        binding.viewModel = this
    }

    private fun setupEvents() = with(binding) {

    }

    private fun observeData() = with(viewModel) {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                errorMsd.collect {
                    if (it.isNotEmpty()) {
                        Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
                        resetError()
                    }
                }
            }
        }
    }
}
