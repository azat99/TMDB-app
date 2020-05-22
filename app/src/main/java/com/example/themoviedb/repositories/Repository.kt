package com.example.themoviedb.repositories

import androidx.lifecycle.LiveData
import com.example.themoviedb.model.entities.Result

interface Repository {

    fun putDataToResilt()
    fun getDataFromResult(): LiveData<List<Result>>

}