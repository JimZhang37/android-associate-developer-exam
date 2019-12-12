package com.example.workmanagertest.data

import androidx.lifecycle.LiveData
import androidx.paging.Config
import androidx.paging.PagedList
import androidx.paging.toLiveData

class LetterRepository private constructor(private val letterDao: LetterDao) {

    companion object {
        private var repository: LetterRepository? = null

        fun create(database: LetterDatabase):LetterRepository?{
            if(repository != null){
                return repository
            }
            else{
                repository = LetterRepository(database.letterDao())
                return repository
            }
        }
    }
    suspend fun insertLetters(vararg letters: Letter) {
        letters.forEach { letterDao.insertAll(it) }
    }

    suspend fun insertLetter(letter: Letter) {
        letterDao.insertAll(letter)
    }

    fun getLetters(): LiveData<PagedList<Letter>> {
        val myPagingConfig = Config(
            pageSize = 6,
            prefetchDistance = 2,
            enablePlaceholders = false,
            initialLoadSizeHint = 6,
            maxSize = 24
        )
        return letterDao.getLetters().toLiveData(myPagingConfig)
    }
}