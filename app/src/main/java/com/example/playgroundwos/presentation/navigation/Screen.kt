package com.example.playgroundwos.presentation.navigation

const val TRAINING_ID_NAV_ARGUMENT = "trainingId"

sealed class Screen(
    val route: String
) {
    object Landing : Screen("landing")
    // object Trainings : Screen("trainings")
    object Exercises : Screen("exercises")
    // object Historic : Screen("historic")
}