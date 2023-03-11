package com.amg.recipes.presentation.master.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RecipeDTO(
    val id: Int,
    val name: String,
    val tagLine: String,
    val description: String,
    val firstBrewed: String,
    val imageUrl: String,
    val foodPairing: List<String>,
    val latitude: Double,
    val longitude: Double,
) : Parcelable