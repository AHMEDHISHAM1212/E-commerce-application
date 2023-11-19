package com.example.e_commerceapplication.ui.tabs.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.domain.model.Category
import com.example.e_commerceapp.ui.home.home.HomeCategoryAdapter
import com.example.e_commerceapp.ui.home.home.HomeContract
import com.example.e_commerceapplication.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _viewBinding: FragmentHomeBinding?= null
    private val binding get() = _viewBinding!!
    lateinit var viewModel : HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentHomeBinding
            .inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        subscribeToLiveData()

    }

    private fun subscribeToLiveData() {
        viewModel.event.observe(viewLifecycleOwner,::handelEvents)
        viewModel.state.observe(viewLifecycleOwner,::renderViewState)
        viewModel.invokeAction(HomeContract.Action.LoadCategories)
    }

    private fun renderViewState(state: HomeContract.State) {
        when(state){
            is HomeContract.State.Error -> showError(state.message)
            is HomeContract.State.Loading -> showLoading(state.message)
            is HomeContract.State.Success -> bindCategories(state.categories)

        }    }

    private fun bindCategories(categories: List<Category?>?) {
        binding?.successView?.isVisible = true
        binding?.loadingView?.isVisible = false
        binding?.errorView?.isVisible = false

        categoriesAdapter.bindCategories(categories)
    }

    private fun showLoading(message: String) {
        _viewBinding?.loadingView?.isVisible = true
        _viewBinding?.successView?.isVisible = false
        _viewBinding?.errorView?.isVisible = false
        _viewBinding?.loadingTxt?.text= message
    }

    private fun showError(message: String) {
        _viewBinding?.errorView?.isVisible = true
        _viewBinding?.loadingView?.isVisible = false
        _viewBinding?.successView?.isVisible = false
        _viewBinding?.errorTxt?.text= message
        _viewBinding?.btnTryAgain?.setOnClickListener{
            viewModel.invokeAction(HomeContract.Action.LoadCategories)
        }
    }

    private fun handelEvents(event: HomeContract.Event) {
        when(event){
            is HomeContract.Event.NavigateToSubCategory -> TODO()
        }
    }
    private val categoriesAdapter = HomeCategoryAdapter(null)

    private fun initViews() {
        binding.rvCategories.adapter = categoriesAdapter
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _viewBinding?.unbind()
        _viewBinding= null
    }
}