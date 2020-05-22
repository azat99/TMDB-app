package com.example.themoviedb

import com.example.themoviedb.model.api.ApiService
import com.example.themoviedb.model.database.MovieDatabase
import com.example.themoviedb.repositories.Repository
import com.example.themoviedb.repositories.RepositoryImpl
import com.example.themoviedb.viewModel.DetailsViewModel
import com.example.themoviedb.viewModel.MovieViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule= module {
    single {
        RepositoryImpl(
            MovieDatabase(context = androidContext()).getResultDao(),
            ApiService()
        ) as Repository
    }

    viewModel { MovieViewModel(get()) }
    viewModel { DetailsViewModel(get()) }
}