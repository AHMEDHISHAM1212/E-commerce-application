package com.example.e_commerceapp.ui.home.home

import androidx.lifecycle.LiveData
import com.example.domain.model.Category

class HomeContract {

    interface ViewModel {
        val state: LiveData<State>
        val event: LiveData<Event>
        fun invokeAction(action: Action)
    }
    sealed class State{
        class Error(val message: String): State()
        class Loading(val message: String): State()
        class Success(val categories: List<Category?>?): State()
    }
    sealed class Event{
        class NavigateToSubCategory(val category: Category) : Event()
    }
    sealed class Action{
        object LoadCategories:Action()
        class CategoryClicked(val category: Category) : Action()
    }
}