package com.example.e_commerceapp.ui.home.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.Category
import com.example.e_commerceapplication.databinding.ItemCategoryHomeBinding

class HomeCategoryAdapter(private var categoryList: List<Category?>?) : RecyclerView.Adapter<HomeCategoryAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding= ItemCategoryHomeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemCategory= categoryList?.get(position)!!
        holder.bind(itemCategory)
    }


    override fun getItemCount(): Int = categoryList?.size?:0

    fun bindCategories(categories: List<Category?>?) {
        this.categoryList= categories
        notifyDataSetChanged()
    }

    class ViewHolder(private val itemBinding: ItemCategoryHomeBinding): RecyclerView.ViewHolder(itemBinding.root){
        fun bind(category: Category){
            itemBinding.category= category
            itemBinding.executePendingBindings()
        }
    }
}