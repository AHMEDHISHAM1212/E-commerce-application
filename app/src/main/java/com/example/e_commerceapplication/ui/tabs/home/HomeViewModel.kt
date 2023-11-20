package com.example.e_commerceapplication.ui.tabs.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetCategoriesUseCase
import com.example.e_commerceapp.ui.home.home.HomeContract
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val categoriesUseCase: GetCategoriesUseCase
) : ViewModel(), HomeContract.ViewModel {

    private val _state = MutableLiveData<HomeContract.State>()
    override val state: LiveData<HomeContract.State> = _state

    private val _event = MutableLiveData<HomeContract.Event>()
    override val event: LiveData<HomeContract.Event> = _event


    override fun invokeAction(action: HomeContract.Action) {
        when (action) {
            is HomeContract.Action.LoadCategories -> loadCategories()

            is HomeContract.Action.CategoryClicked -> TODO()
        }
    }

    private fun loadCategories() {
        viewModelScope.launch {
            try {
                _state.postValue(HomeContract.State.Loading("Loading.."))
                val data = categoriesUseCase.invoke()
                _state.postValue(HomeContract.State.Success(data))

            } catch (e: Exception) {
                _state.postValue(HomeContract.State.Error(e.localizedMessage))
            }
        }
    }
}