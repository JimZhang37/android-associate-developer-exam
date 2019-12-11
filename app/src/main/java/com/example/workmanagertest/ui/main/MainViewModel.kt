package com.example.workmanagertest.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.example.workmanagertest.worker.NotificationWorker
import java.util.concurrent.TimeUnit

class MainViewModel(application: Application) : AndroidViewModel(application) {
    // TODO: Implement the ViewModel

    fun notifyUser() {
//        val constraints = Constraints.Builder()
//            .setRequiresDeviceIdle(true)
//            .build()
        val inputData = workDataOf("URI" to "www.abc.com")

        val nortificationWorkRequest = OneTimeWorkRequestBuilder<NotificationWorker>()
            .setInitialDelay(10, TimeUnit.SECONDS)
            .setInputData(inputData)
            .build()

        WorkManager.getInstance(getApplication()).enqueue(nortificationWorkRequest)
    }
}
