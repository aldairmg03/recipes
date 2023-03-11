package com.amg.recipes.di

import com.amg.recipes.data.remote.RecipeRemoteDataSource
import com.amg.recipes.data.remote.RecipeRemoteDataSourceImpl
import com.amg.recipes.data.remote.RecipesService
import com.amg.recipes.data.repository.RecipeRepository
import com.amg.recipes.data.repository.RecipeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object RecipesModule {

    @Provides
    fun provideMovieService(retrofit: Retrofit): RecipesService =
        retrofit.create(RecipesService::class.java)

    @Provides
    fun provideMovieRemoteDataSource(
        recipesService: RecipesService
    ): RecipeRemoteDataSource = RecipeRemoteDataSourceImpl(recipesService)

    @Provides
    fun provideRepository(
        remoteDataSource: RecipeRemoteDataSource,
    ): RecipeRepository = RecipeRepositoryImpl(remoteDataSource)


}