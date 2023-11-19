package com.example.e_commerceapplication.ui.tabs.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.e_commerceapplication.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    lateinit var viewBinding : FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentProfileBinding
            .inflate(inflater,container,false)
        return viewBinding.root
    }
}