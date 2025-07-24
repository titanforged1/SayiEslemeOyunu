package com.sebnem.sayieslemeoyunu.presentation.game

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun GameScreen(
    navController: NavController,
    username: String,
    difficulty: String,
    viewModel: GameViewModel = hiltViewModel()
) {

    val cards by viewModel.cards.collectAsState()
    val score by viewModel.score.collectAsState()
    val time by viewModel.remainingTime.collectAsState()
    val gameFinished by viewModel.gameFinished.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Skor ve süre bilgileri üstte
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "🏆 Skor: $score",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "⏱ Süre: $time sn",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Oyuncu bilgileri ortada
        Text(
            text = "👤 Oyuncu: $username",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            text = "🎮 Zorluk: $difficulty",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Kartlar
        val columns = if (difficulty == "Kolay") 4 else 4 // Her iki zorluk için de 4 sütun
        cards.chunked(columns).forEach { row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                row.forEach { card ->
                    val backgroundColor = when {
                        card.isMatched -> MaterialTheme.colorScheme.primary
                        card.isFaceUp -> MaterialTheme.colorScheme.secondary
                        else -> MaterialTheme.colorScheme.outline
                    }

                    Card(
                        onClick = { viewModel.onCardClicked(card) },
                        modifier = Modifier
                            .size(if (difficulty == "Kolay") 70.dp else 60.dp)
                            .padding(4.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = backgroundColor
                        ),
                        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            if (card.isFaceUp || card.isMatched) {
                                Text(
                                    text = card.number.toString(),
                                    style = MaterialTheme.typography.titleLarge,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onPrimary
                                )
                            } else {
                                Text(
                                    text = "?",
                                    style = MaterialTheme.typography.titleLarge,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    LaunchedEffect(gameFinished) {
        if (gameFinished) {
            viewModel.saveScore(username, difficulty)
        }
    }

    if (gameFinished) {
        AlertDialog(
            onDismissRequest = {},
            confirmButton = {
                Button(onClick = {
                    navController.popBackStack()
                }) {
                    Text("Ana Menüye Dön")
                }
            },
            dismissButton = {
                Button(onClick = {
                    viewModel.restartGame()
                }) {
                    Text("Tekrar Oyna")
                }
            },
            title = {
                Text(
                    if (cards.all { it.isMatched })
                        "🎉 Tebrikler Kazandın!"
                    else
                        "⏰ Süre Doldu!"
                )
            },
            text = {
                Text("Skorun: $score\nOyuncu: $username\nZorluk: $difficulty")
            }
        )
    }
}