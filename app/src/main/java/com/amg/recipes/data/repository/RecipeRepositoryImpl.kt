package com.amg.recipes.data.repository

import com.amg.recipes.data.remote.RecipeRemoteDataSource
import com.amg.recipes.data.remote.Result
import com.amg.recipes.data.remote.model.Recipe
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(
    private val recipeRemoteDataSource: RecipeRemoteDataSource
) : RecipeRepository {

    override suspend fun getBeerRecipes(): Result<List<Recipe>> =
        recipeRemoteDataSource.getBeerRecipes()

}