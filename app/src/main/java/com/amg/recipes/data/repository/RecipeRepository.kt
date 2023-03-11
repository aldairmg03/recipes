package com.amg.recipes.data.repository

import com.amg.recipes.data.remote.Result
import com.amg.recipes.data.remote.model.Recipe

interface RecipeRepository {

    suspend fun getBeerRecipes(): Result<List<Recipe>>

}