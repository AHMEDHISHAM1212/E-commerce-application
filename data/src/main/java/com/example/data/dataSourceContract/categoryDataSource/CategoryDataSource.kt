package com.example.data.dataSourceContract.categoryDataSource


import com.example.domain.model.Category

interface CategoryDataSource {
    suspend fun getCategories(): List<Category?>?
}