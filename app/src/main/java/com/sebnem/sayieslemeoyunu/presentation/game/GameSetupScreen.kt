package com.sebnem.sayieslemeoyunu.presentation.game

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sebnem.sayieslemeoyunu.presentation.navigation.Screen

@Composable
fun GameSetupScreen(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var difficulty by remember { mutableStateOf("Kolay") }
    val options = listOf("Kolay", "Zor")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Oyuncu Adı",
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = username,
            onValueChange = { username = it },
            placeholder = { Text("Adınızı girin") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            "Zorluk Seviyesi",
            fontSize = 20.sp)

        options.forEach { option ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = (option == difficulty),
                        onClick = { difficulty = option }
                    )
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (option == difficulty),
                    onClick = { difficulty = option }
                )
                Text(option)
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        ElevatedButton(
            shape = RectangleShape,
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp),
            onClick = {

                val encodedName = username.replace(" ", "%20")
                navController.navigate(
                    Screen.Game.passArgs(username = username, difficulty = difficulty)
                )

            },
            enabled = username.isNotBlank()
        ) {
            Text("Oyuna Başla")
        }

    }
}
