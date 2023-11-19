package com.example.data.repositoryImpl.categoryRepo

import com.example.data.dataSourceContract.categoryDataSource.CategoryDataSource
import com.example.domain.model.Category
import com.example.domain.repository.CategoriesRepository
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
     private val dataSource: CategoryDataSource
) : CategoriesRepository {
    override suspend fun getCategories(): List<Category?>? {
        return dataSource.getCategories()
    }
}