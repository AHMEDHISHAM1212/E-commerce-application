package com.example.e_commerceapplication.ui.tabs.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.e_commerceapplication.databinding.FragmentCategoryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryFragment : Fragment() {
    private var _viewBinding: FragmentCategoryBinding? = null

    // to avoid the memory leak in viewBinding
    private val viewBinding get() = _viewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentCategoryBinding
            .inflate(inflater, container, false)
        return _viewBinding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _viewBinding?.unbind()
        _viewBinding = null

        _viewBinding= null


    }
}