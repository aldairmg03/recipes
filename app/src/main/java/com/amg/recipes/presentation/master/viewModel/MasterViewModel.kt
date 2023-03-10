package com.amg.recipes.presentation.master.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amg.recipes.data.remote.Result
import com.amg.recipes.domain.usecases.GetRecipesUseCases
import com.amg.recipes.presentation.master.dto.RecipeDTO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MasterViewModel @Inject constructor(
    private val getRecipesUseCases: GetRecipesUseCases
) : ViewModel() {

    private val _showMessageMLD = MutableLiveData<String>()
    val onShowMessage: LiveData<String> get() = _showMessageMLD

    private val _showLoadingMLD = MutableLiveData<Boolean>()
    val onShowLoading: LiveData<Boolean> get() = _showLoadingMLD

    private val _recipesCatalogMLD = MutableLiveData<List<RecipeDTO>>()
    val onRecipesCatalog: LiveData<List<RecipeDTO>> get() = _recipesCatalogMLD

    fun getRecipes() {
        showLoading(true)
        viewModelScope.launch {
            when (val result = getRecipesUseCases.invoke()) {
                is Result.Error -> {
                    _showMessageMLD.value = result.exception.message ?: ""
                    showLoading(false)
                }
                is Result.Success -> {
                    val recipes = result.data.map { recipe ->
                        RecipeDTO(
                            recipe.id,
                            recipe.name,
                            recipe.tagLine,
                            recipe.description,
                            recipe.firstBrewed,
                            recipe.imageUrl,
                            recipe.foodPairing,
                            recipe.latitude,
                            recipe.longitude
                        )
                    }
                    _recipesCatalogMLD.value = recipes
                    showLoading(false)
                }
            }
        }

    }

    private fun showLoading(isShow: Boolean) {
        _showLoadingMLD.value = isShow
    }

}