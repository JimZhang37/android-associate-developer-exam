package com.example.workmanagertest.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Letter::class), version = 1,exportSchema = false)
abstract class LetterDatabase : RoomDatabase() {
    abstract fun letterDao(): LetterDao

    companion object {
        private  var instance: LetterDatabase? = null
        fun create(context: Context): LetterDatabase? {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    LetterDatabase::class.java, "database-name"
                ).build()
            }
            return instance
        }
    }
}