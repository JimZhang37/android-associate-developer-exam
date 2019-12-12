package com.example.workmanagertest.ui.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.workmanagertest.R

import com.example.workmanagertest.ui.list.ui.list.ListFragment

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ListFragment.newInstance())
                .commitNow()
        }
    }

}
