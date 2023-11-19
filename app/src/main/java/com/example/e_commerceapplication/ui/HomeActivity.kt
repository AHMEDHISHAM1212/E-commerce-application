package com.example.e_commerceapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.e_commerceapplication.R
import com.example.e_commerceapplication.databinding.ActivityHomeBinding
import com.example.e_commerceapplication.ui.tabs.category.CategoryFragment
import com.example.e_commerceapplication.ui.tabs.home.HomeFragment
import com.example.e_commerceapplication.ui.tabs.profile.ProfileFragment
import com.example.e_commerceapplication.ui.tabs.whishList.WishListFragment
import com.google.android.material.navigation.NavigationBarView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() , NavigationBarView.OnItemSelectedListener {

    private lateinit var viewBinding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
    }
    private fun initViews() {
        viewBinding = DataBindingUtil.setContentView(this,R.layout.activity_home)
        // nav click
        viewBinding.bottomNavHome.selectedItemId = R.id.bottom_nav_home

        viewBinding.bottomNavHome.setOnItemSelectedListener (this)
        //default fragment will open
        viewBinding.bottomNavHome.selectedItemId = R.id.bottom_nav_home
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.ic_home_nav -> pushFragment(HomeFragment())
            R.id.ic_category_nav -> pushFragment(CategoryFragment())
            R.id.ic_wish_list_nav -> pushFragment(WishListFragment())
            R.id.ic_profile_nav -> pushFragment(ProfileFragment())
        }
        return true
    }
    private fun pushFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_home_container,fragment)
            .commit()

    }
}