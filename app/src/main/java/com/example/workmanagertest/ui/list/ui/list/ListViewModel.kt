package com.example.workmanagertest.ui.list.ui.list

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.workmanagertest.MyApplication
import com.example.workmanagertest.data.Letter

class ListViewModel(app: MyApplication) : AndroidViewModel(app) {
    val repository = getApplication<MyApplication>().repository
    private var _data = repository.getLetters()
    val data: LiveData<PagedList<Letter>>
        get() = _data
}
