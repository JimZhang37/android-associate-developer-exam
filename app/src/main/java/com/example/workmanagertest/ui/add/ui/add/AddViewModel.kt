package com.example.workmanagertest.ui.add.ui.add

import androidx.lifecycle.*
import com.example.workmanagertest.MyApplication
import com.example.workmanagertest.data.Letter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddViewModel(app: MyApplication) : AndroidViewModel(app) {
    private val repository = getApplication<MyApplication>().repository
    val created = System.currentTimeMillis()
    fun save(subject:String, content:String) {
        val letter = Letter(
            id = null,
            subject = subject,
            content = content,
            created = created,
            expired = 2,
            opened = null
        )
        viewModelScope.launch(Dispatchers.IO) { repository.insertLetter(letter) }

    }
}

