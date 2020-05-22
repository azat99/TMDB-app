package com.example.themoviedb.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.themoviedb.model.entities.Result
import com.example.themoviedb.repositories.Repository

class DetailsViewModel(private val repo:Repository) : ViewModel() {

    fun getDataFromArticle(): LiveData<List<Result>> {
        return repo.getDataFromResult()
    }

}
