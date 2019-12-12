package com.example.workmanagertest.ui.add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.workmanagertest.R
import com.example.workmanagertest.ui.add.ui.add.AddFragment

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, AddFragment.newInstance())
                .commitNow()
        }
    }

}
