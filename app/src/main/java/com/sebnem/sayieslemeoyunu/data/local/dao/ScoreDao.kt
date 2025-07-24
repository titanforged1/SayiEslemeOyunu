package com.sebnem.sayieslemeoyunu.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.sebnem.sayieslemeoyunu.data.local.entity.ScoreEntity

@Dao
interface ScoreDao {

    @Insert
    suspend fun insertScore(score: ScoreEntity)

    @Query("SELECT * FROM scores ORDER BY score DESC")
    suspend fun getAllScores(): List<ScoreEntity>

    @Query("DELETE FROM scores")
    suspend fun clearScores()
}
