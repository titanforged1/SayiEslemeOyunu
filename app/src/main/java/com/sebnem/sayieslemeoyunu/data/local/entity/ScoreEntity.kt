package com.sebnem.sayieslemeoyunu.data.local.entity


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "scores")
data class ScoreEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val username: String,
    val score: Int,
    val difficulty: String,
    val timestamp: Long = System.currentTimeMillis()
)
