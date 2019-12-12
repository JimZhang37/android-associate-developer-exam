package com.example.workmanagertest.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "letter")
data class Letter(
    @PrimaryKey(autoGenerate = true)
    val id: Long?,
    val subject: String,
    val content: String,
    val created: Long,
    val expired: Long,
    val opened: Int?
)