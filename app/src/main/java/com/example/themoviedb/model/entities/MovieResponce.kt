package com.example.themoviedb.model.entities


import com.google.gson.annotations.SerializedName

data class MovieResponce(
    @SerializedName("page")
    val page: Int,
    @SerializedName("total_results")
    val totalResults: Int,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("results")
    val results: List<Result>
)