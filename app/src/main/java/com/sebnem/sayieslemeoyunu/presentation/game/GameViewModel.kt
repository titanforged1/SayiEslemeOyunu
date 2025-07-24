package com.sebnem.sayieslemeoyunu.presentation.game

import androidx.lifecycle.*
import com.sebnem.sayieslemeoyunu.data.local.dao.ScoreDao
import com.sebnem.sayieslemeoyunu.data.local.entity.ScoreEntity
import com.sebnem.sayieslemeoyunu.domain.model.MemoryCard
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val scoreDao: ScoreDao,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _cards = MutableStateFlow<List<MemoryCard>>(emptyList())
    val cards: StateFlow<List<MemoryCard>> = _cards

    private val _score = MutableStateFlow(0)
    val score: StateFlow<Int> = _score

    private val _remainingTime = MutableStateFlow(60)
    val remainingTime: StateFlow<Int> = _remainingTime

    private val _gameFinished = MutableStateFlow(false)
    val gameFinished: StateFlow<Boolean> = _gameFinished

    private var selectedCards = mutableListOf<MemoryCard>()
    private var timerJob: kotlinx.coroutines.Job? = null

    private val difficulty: String = savedStateHandle["difficulty"] ?: "Kolay"

    init {
        startGame()
    }

    private fun startGame() {
        val cardCount = if (difficulty == "Kolay") 16 else 24
        val pairCount = cardCount / 2
        val numbers = (1..100).shuffled().take(pairCount)
        val memoryCards = numbers.flatMap { num ->
            listOf(
                MemoryCard(id = num * 2, number = num),
                MemoryCard(id = num * 2 + 1, number = num)
            )
        }.shuffled()
        _cards.value = memoryCards

        startTimer()
    }

    fun restartGame() {
        timerJob?.cancel()
        _score.value = 0
        _remainingTime.value = 60
        _gameFinished.value = false
        selectedCards.clear()
        startGame()
    }

    private fun startTimer() {
        timerJob?.cancel()
        timerJob = viewModelScope.launch {
            while (_remainingTime.value > 0 && !_gameFinished.value) {
                delay(1000)
                _remainingTime.value = _remainingTime.value - 1

                if (_cards.value.all { it.isMatched }) {
                    _gameFinished.value = true
                    break
                }
            }

            if (_remainingTime.value == 0) {
                _gameFinished.value = true
            }
        }
    }

    fun onCardClicked(card: MemoryCard) {
        if (card.isFaceUp || card.isMatched || selectedCards.size == 2 || _gameFinished.value) return

        val currentCards = _cards.value.toMutableList()
        val index = currentCards.indexOfFirst { it.id == card.id }
        if (index == -1) return

        currentCards[index] = currentCards[index].copy(isFaceUp = true)
        _cards.value = currentCards
        selectedCards.add(currentCards[index])

        if (selectedCards.size == 2) {
            viewModelScope.launch {
                delay(1000)
                checkForMatch()
            }
        }
    }

    private fun checkForMatch() {
        val updatedCards = _cards.value.toMutableList()
        val (first, second) = selectedCards

        if (first.number == second.number) {
            updatedCards.replaceAll {
                if (it.id == first.id || it.id == second.id) it.copy(isMatched = true)
                else it
            }
            _score.value += 10
        } else {
            updatedCards.replaceAll {
                if (it.id == first.id || it.id == second.id) it.copy(isFaceUp = false)
                else it
            }
        }

        _cards.value = updatedCards
        selectedCards.clear()

        if (_cards.value.all { it.isMatched }) {
            _gameFinished.value = true
        }
    }

    fun saveScore(username: String, difficulty: String) {
        viewModelScope.launch {
            val scoreEntry = ScoreEntity(
                username = username,
                score = _score.value,
                difficulty = difficulty
            )
            scoreDao.insertScore(scoreEntry)
        }
    }

    override fun onCleared() {
        super.onCleared()
        timerJob?.cancel()
    }
}