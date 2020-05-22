package com.example.themoviedb.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.themoviedb.model.api.ApiService
import com.example.themoviedb.model.entities.Result
import com.example.themoviedb.model.entities.ResultDao
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception

class RepositoryImpl(
    private val resultDao: ResultDao,
    private val apiService: ApiService
) : Repository {


    override fun putDataToResilt() {
        val apiKey = "77d9e37a26d9e044eab84fed8aeb6ebd"
        val language = "en-US"
        val page = 1
        try {
            GlobalScope.launch {
                val result = apiService.getMovieList(apiKey,language, page).await()
                resultDao.deleteResult()
                resultDao.insertAllResult(result.results)
            }
        }catch (e: Exception){
            Log.i("exeption_error",e.printStackTrace().toString())
        }
    }

    override fun getDataFromResult(): LiveData<List<Result>> {
        return resultDao.getAllResult()
    }
}