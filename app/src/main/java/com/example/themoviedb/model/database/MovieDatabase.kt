package com.example.themoviedb.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.themoviedb.model.entities.Result
import com.example.themoviedb.model.entities.ResultDao

@Database(
    entities = [Result::class],
    version = 2
)
abstract class MovieDatabase :RoomDatabase(){

    abstract fun getResultDao(): ResultDao

    companion object {

        @Volatile
        private var instance: MovieDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            MovieDatabase::class.java,
            "movie_db"
        ).fallbackToDestructiveMigration().build()

    }

}