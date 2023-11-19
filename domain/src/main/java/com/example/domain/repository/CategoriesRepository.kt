package com.example.domain.repository

import com.example.domain.model.Category

interface CategoriesRepository {
    suspend fun getCategories(): List<Category?>?
}