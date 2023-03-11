package com.amg.recipes.data.remote

import com.amg.recipes.constants.RecipesConstants
import com.amg.recipes.data.remote.model.Recipe
import retrofit2.Response
import retrofit2.http.GET

interface RecipesService {

    @GET(RecipesConstants.BEER_RECIPES)
    suspend fun getBeerRecipes(): Response<List<Recipe>>

}