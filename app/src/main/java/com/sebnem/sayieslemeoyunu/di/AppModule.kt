package com.sebnem.sayieslemeoyunu.di

import android.content.Context
import androidx.room.Room
import com.sebnem.sayieslemeoyunu.data.local.ScoreDatabase
import com.sebnem.sayieslemeoyunu.data.local.dao.ScoreDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): ScoreDatabase {
        return Room.databaseBuilder(
            context,
            ScoreDatabase::class.java,
            "score_db"
        ).build()
    }

    @Provides
    fun provideScoreDao(db: ScoreDatabase): ScoreDao = db.scoreDao()
}
