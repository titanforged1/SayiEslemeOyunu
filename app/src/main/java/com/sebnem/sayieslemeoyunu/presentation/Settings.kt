package com.sebnem.sayieslemeoyunu.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(navController: NavController) {
    var isDarkTheme by remember { mutableStateOf(false) }
    var isTimerEnabled by remember { mutableStateOf(true) }
    var showClearDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "⚙️ Ayarlar",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Geri")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Spacer(modifier = Modifier.height(32.dp))

            // Tema ayarları
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "🎨 Tema Ayarları",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = !isDarkTheme,
                                onClick = { isDarkTheme = false }
                            )
                            .padding(vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = !isDarkTheme,
                            onClick = { isDarkTheme = false }
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("☀️ Açık Tema")
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = isDarkTheme,
                                onClick = { isDarkTheme = true }
                            )
                            .padding(vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = isDarkTheme,
                            onClick = { isDarkTheme = true }
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("🌙 Koyu Tema")
                    }
                }
            }

            // Oyun ayarları
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "🎮 Oyun Ayarları",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "⏱️ Süre Göstergesi",
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Switch(
                            checked = isTimerEnabled,
                            onCheckedChange = { isTimerEnabled = it }
                        )
                    }
                }
            }

            // Veri yönetimi
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "🗄️ Veri Yönetimi",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    Button(
                        onClick = { showClearDialog = true },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.error
                        )
                    ) {
                        Text("🗑️ Skor Listesini Sıfırla")
                    }
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            // Uygulama bilgisi
//            Card(
//                modifier = Modifier.fillMaxWidth(),
//                colors = CardDefaults.cardColors(
//                    containerColor = MaterialTheme.colorScheme.surfaceVariant
//                )
//            ) {
////                Column(
////                    modifier = Modifier.padding(16.dp),
////                    horizontalAlignment = Alignment.CenterHorizontally
////                ) {
////                    Text(
////                        text = "📱 Sayı Eşleme Oyunu",
////                        style = MaterialTheme.typography.titleMedium,
////                        fontWeight = FontWeight.Medium
////                    )
////                    Text(
////                        text = "Versiyon 1.0.0",
////                        style = MaterialTheme.typography.bodyMedium,
////                        color = MaterialTheme.colorScheme.onSurfaceVariant
////                    )
////                    Text(
////                        text = "Android Bootcamp Bitirme Projesi",
////                        style = MaterialTheme.typography.bodySmall,
////                        color = MaterialTheme.colorScheme.onSurfaceVariant,
////                        modifier = Modifier.padding(top = 4.dp)
////                    )
////                }
////            }
//            }
        }

        // Skor silme onay dialogu
        if (showClearDialog) {
            AlertDialog(
                onDismissRequest = { showClearDialog = false },
                title = { Text("Skorları Sıfırla") },
                text = { Text("Tüm skorları silmek istediğinizden emin misiniz? Bu işlem geri alınamaz.") },
                confirmButton = {
                    Button(
                        onClick = {
                            // Burada skor silme işlemi yapılacak
                            // ScoreDao'ya erişim gerekecek
                            showClearDialog = false
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.error
                        )
                    ) {
                        Text("Sıfırla")
                    }
                },
                dismissButton = {
                    OutlinedButton(onClick = { showClearDialog = false }) {
                        Text("İptal")
                    }
                }
            )
        }
    }
}