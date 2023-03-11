package com.amg.recipes.data.remote.model

import com.google.gson.annotations.SerializedName

data class Recipe(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("tagline")
    val tagLine: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("first_brewed")
    val firstBrewed: String,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("food_pairing")
    val foodPairing: List<String>,
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("longitude")
    val longitude: Double
)