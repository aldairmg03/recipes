package com.amg.recipes.data.remote

import com.amg.recipes.data.remote.model.Recipe

interface RecipeRemoteDataSource {

    suspend fun getBeerRecipes(): Result<List<Recipe>>

}