package com.example.data.repositoryImpl.categoryRepo

import com.example.domain.repository.CategoriesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class di {

    @Binds
    abstract fun provideCategoriesRepository(
        categoryRepositoryImpl: CategoryRepositoryImpl
    ): CategoriesRepository

}
