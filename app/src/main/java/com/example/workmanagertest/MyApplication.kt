package com.example.workmanagertest

import android.app.Application
import android.content.SharedPreferences
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.Preference
import androidx.preference.PreferenceManager
import com.example.workmanagertest.data.LetterDatabase
import com.example.workmanagertest.data.LetterRepository

class MyApplication : Application(), SharedPreferences.OnSharedPreferenceChangeListener {
    override fun onCreate() {
        super.onCreate()

        val sharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(this /* Activity context */)
        setTheme(sharedPreferences)

        sharedPreferences.registerOnSharedPreferenceChangeListener(this)
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        if (key == "theme") {
            Log.i(
                "MyApplication",
                "Preference value was updated to: " + sharedPreferences?.getString(key, "")
            )
            setTheme(sharedPreferences)
        }
    }

    private fun setTheme(sharedPreferences: SharedPreferences?) {
        val name = sharedPreferences?.getString("theme", "MODE_NIGHT_YES")
        AppCompatDelegate.setDefaultNightMode(
            when (name) {
                "MODE_NIGHT_NO" -> AppCompatDelegate.MODE_NIGHT_NO
                "MODE_NIGHT_YES" -> AppCompatDelegate.MODE_NIGHT_YES
                "MODE_NIGHT_AUTO_BATTERY" -> AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY
                "MODE_NIGHT_FOLLOW_SYSTEM" -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
                else -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
            }
        )
    }

    val repository: LetterRepository
        get() = LetterRepository.create(LetterDatabase.create(this)!!)!!
}