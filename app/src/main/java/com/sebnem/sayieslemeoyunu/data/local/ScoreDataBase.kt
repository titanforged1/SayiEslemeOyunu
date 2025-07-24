package com.sebnem.sayieslemeoyunu.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sebnem.sayieslemeoyunu.data.local.dao.ScoreDao
import com.sebnem.sayieslemeoyunu.data.local.entity.ScoreEntity

@Database(entities = [ScoreEntity::class], version = 1)
abstract class ScoreDatabase : RoomDatabase() {
    abstract fun scoreDao(): ScoreDao
}
