package com.example.themoviedb.model.entities

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ResultDao {

    @Query("select * from result")
    fun getAllResult(): LiveData<List<Result>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllResult(articleList: List<Result>)

    @Query("delete from result")
    fun deleteResult()

}