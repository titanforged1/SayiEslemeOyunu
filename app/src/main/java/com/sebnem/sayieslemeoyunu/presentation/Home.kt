package com.sebnem.sayieslemeoyunu.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sebnem.sayieslemeoyunu.presentation.navigation.Screen

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(100.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Sayı Eşleme Oyunu",
            fontSize = 27.sp
        )

        Spacer(
            modifier = Modifier.height(48.dp)
        )

        ElevatedButton(
            shape = RectangleShape,
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp),
            onClick = {
                navController.navigate(
                    Screen.GameSetup.route
                )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Başla")
        }

        Spacer(modifier = Modifier.height(16.dp))

        ElevatedButton(
            shape = RectangleShape,
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp),
            onClick = {
                navController.navigate(
                    Screen.Score.route
                )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Skorlarım")
        }

        Spacer(modifier = Modifier.height(16.dp))

        ElevatedButton(
            shape = RectangleShape,
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp),
            onClick = {
                navController.navigate(
                    Screen.Settings.route
                )
            },

            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ayarlar")
        }


    }
}
