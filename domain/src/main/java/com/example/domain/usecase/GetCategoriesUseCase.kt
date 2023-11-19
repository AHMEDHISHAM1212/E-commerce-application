package com.example.domain.usecase

import com.example.domain.model.Category
import com.example.domain.repository.CategoriesRepository
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val repository: CategoriesRepository
        ) {
    //it will used in the view model
    suspend fun invoke(): List<Category?>? {
        return repository.getCategories()
    }

}