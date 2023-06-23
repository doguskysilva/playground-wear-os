package com.example.playgroundwos.presentation.navigation

const val TRAINING_ID_NAV_ARGUMENT = "trainingId"

const val SCROLL_TYPE_NAV_ARGUMENT = "scrollType"

sealed class Screen(
    val route: String
) {
    object Landing : Screen("landing")
    object Trainings : Screen("trainings")
    object Exercises : Screen("exercises")
    object Historic : Screen("historic")
}