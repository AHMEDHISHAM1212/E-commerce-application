package com.example.data.dataSourceImpl.categoryDataSourceImpl

import com.example.data.api.WebService
import com.example.data.dataSourceContract.categoryDataSource.CategoryDataSource
import com.example.domain.model.Category
import javax.inject.Inject


class CategoryOnlineDataSourceImpl @Inject constructor(
    private val webService: WebService
    ) : CategoryDataSource {
    override suspend fun getCategories(): List<Category?>? {
        val response = webService.getCategories()
        return response.data?.map {
            it?.toCategory()
        }

    }
}