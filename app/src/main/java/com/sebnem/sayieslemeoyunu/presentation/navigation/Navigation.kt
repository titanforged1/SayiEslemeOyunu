package com.sebnem.sayieslemeoyunu.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.sebnem.sayieslemeoyunu.presentation.game.GameSetupScreen
import com.sebnem.sayieslemeoyunu.presentation.score.ScoreScreen
import com.sebnem.sayieslemeoyunu.presentation.SettingsScreen
import com.sebnem.sayieslemeoyunu.presentation.game.GameScreen
import com.sebnem.sayieslemeoyunu.presentation.home.HomeScreen
import com.sebnem.sayieslemeoyunu.presentation.score.ScoreViewModel

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Score : Screen("score")
    object Settings : Screen("settings")
    object GameSetup : Screen("setup")
    object Game : Screen("game_screen/{username}/{difficulty}") {
        fun passArgs(username: String, difficulty: String): String {
            return "game_screen/$username/$difficulty"
        }
    }
}

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(Screen.Score.route) {
            ScoreScreen(navController = navController)
        }
        composable(Screen.Settings.route) {
            SettingsScreen(navController)
        }
        composable(Screen.GameSetup.route) {
            GameSetupScreen(navController)
        }
        composable(
            route = "game_screen/{username}/{difficulty}",
            arguments = listOf(
                navArgument("username") { type = NavType.StringType },
                navArgument("difficulty") { type = NavType.StringType }
            )
        ) {
            val username = it.arguments?.getString("username") ?: ""
            val difficulty = it.arguments?.getString("difficulty") ?: "Kolay"
            GameScreen(
                navController = navController,
                username = username,
                difficulty = difficulty
            )
        }
    }
}