package com.amg.recipes.domain.usecases

import com.amg.recipes.data.remote.Result
import com.amg.recipes.data.remote.model.Recipe
import com.amg.recipes.data.repository.RecipeRepository
import javax.inject.Inject

class GetRecipesUseCases @Inject constructor(
    private val recipeRepository: RecipeRepository
) {

    suspend fun invoke(): Result<List<Recipe>> = recipeRepository.getBeerRecipes()

}