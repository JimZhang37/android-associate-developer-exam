package com.example.workmanagertest.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.workmanagertest.MyApplication

class MyViewModelFactory(val app: MyApplication) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(MyApplication::class.java).newInstance(app)
//        return AddViewModel(app) as T
    }
}