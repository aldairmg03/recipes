package com.amg.recipes.data.remote

import com.amg.recipes.base.BaseDataSource
import com.amg.recipes.data.remote.model.Recipe
import javax.inject.Inject

class RecipeRemoteDataSourceImpl @Inject constructor(
    private val recipesService: RecipesService
) : BaseDataSource(), RecipeRemoteDataSource {
    override suspend fun getBeerRecipes(): Result<List<Recipe>> = getResponse {
        recipesService.getBeerRecipes()
    }
}