package com.sebnem.sayieslemeoyunu.domain.model

data class MemoryCard(
    val id: Int,              // her kartın benzersiz ID'si
    val number: Int,          // karttaki sayı
    var isFaceUp: Boolean = false,
    var isMatched: Boolean = false
)
