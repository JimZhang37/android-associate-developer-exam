package com.example.workmanagertest.data

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

//import androidx.paging.DataSource
//import androidx.paging.DataSource.Factory

@Dao
interface LetterDao {


    @Query("SELECT * FROM letter")
    fun getLetters(): DataSource.Factory<Int, Letter>

    @Insert
    suspend fun insertAll(vararg letters: Letter)

    @Insert
    suspend fun insertLetter(letters: Letter)
}