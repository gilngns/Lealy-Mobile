package com.example.start.presentation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.start.presentation.screen.*

@Composable
fun StartNavGraph(navController: NavHostController) {
    val startViewModel: StartViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = StartRoute.Welcome.route
    ) {
        composable(StartRoute.Welcome.route) {
            WelcomeScreen(navController)
        }
        composable(StartRoute.Familiarity.route) {
            FamiliarityScreen(navController)
        }
        composable(StartRoute.Instruments.route) {
            InstrumentsScreen(navController)
        }
        composable(StartRoute.Experience.route) {
            ExperienceScreen(navController)
        }
        composable(StartRoute.Topics.route) {
            TopicInterestScreen(navController)
        }
        composable(StartRoute.Confidence.route) {
            ConfidenceScreen(
                navController = navController,
                viewModel = startViewModel
            )
        }
        composable(StartRoute.Result.route) {
            ResultScreen(
                navController = navController,
                viewModel = startViewModel
            )
        }
    }
}
