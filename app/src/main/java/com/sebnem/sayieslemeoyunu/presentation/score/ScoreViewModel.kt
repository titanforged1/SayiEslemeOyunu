package com.sebnem.sayieslemeoyunu.presentation.score

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sebnem.sayieslemeoyunu.data.local.dao.ScoreDao
import com.sebnem.sayieslemeoyunu.data.local.entity.ScoreEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScoreViewModel @Inject constructor(
    private val scoreDao: ScoreDao
) : ViewModel() {

    private val _scores = MutableStateFlow<List<ScoreEntity>>(emptyList())
    val scores: StateFlow<List<ScoreEntity>> = _scores

    init {
        refreshScores()
    }

    fun refreshScores() {
        viewModelScope.launch {
            try {
                val scoreList = scoreDao.getAllScores()
                _scores.value = scoreList
            } catch (e: Exception) {
                // Hata durumunda boş liste
                _scores.value = emptyList()
            }
        }
    }

    fun clearScores() {
        viewModelScope.launch {
            try {
                scoreDao.clearScores()
                _scores.value = emptyList()
            } catch (e: Exception) {
                // Hata durumunda mevcut listeyi koru
            }
        }
    }
}