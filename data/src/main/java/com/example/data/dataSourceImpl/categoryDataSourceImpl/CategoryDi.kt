package com.example.data.dataSourceImpl.categoryDataSoruceImpl

import com.example.data.dataSourceContract.categoryDataSource.CategoryDataSource
import com.example.data.dataSourceImpl.categoryDataSourceImpl.CategoryOnlineDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class CategoryDi {

    @Binds
    abstract fun provideCategoryDataSource(
        categoryOnlineDataSourceImpl: CategoryOnlineDataSourceImpl
    ): CategoryDataSource
}