package com.amg.recipes.presentation.master.dto

data class RecipeDTO(
    val id: Int,
    val name: String,
    val tagLine: String,
    val description: String,
    val firstBrewed: String,
    val imageUrl: String,
    val foodPairing: List<String>
)