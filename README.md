# Recipes
This project is built with MVVM with Clean Architecture. Using the following dependencies:
- Architecture Components (Lifecycle, LiveData, ViewModel, Coroutines)
- Material Components
- Android Hilt for dependency injection
- Retrofit2 for consumption of API REST
- Kotlin Coroutines
- Google Maps
- Glide

# REST API consumption
- Retrofit 2 was used to make request to the REST API, Because it is the most used library in the consumption of REST APIs in Android.

# Repository
- RecipesRepositoryImpl is in charge of obtaining data from the REST API.

# ViewModel
- ViewModels is used to inform the UI of data changes through LiveData

# Android Hilt
- Modules is in charge of injecting the Datasource, Repository, Retrofit dependencies.

# UI
- Fragments are used to display Master, Detail and Map
