package com.example.playgroundwos.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import com.example.playgroundwos.presentation.ui.exercises.ExercisesScreen
import com.example.playgroundwos.presentation.ui.landing.LandingScreen

@Composable
fun NavigationGraph(
    swipeDismissableNavController: NavHostController,
) {
    SwipeDismissableNavHost(
        navController = swipeDismissableNavController,
        startDestination = Screen.Landing.route
    ) {
        composable(
            route = Screen.Landing.route,
        ) {
            LandingScreen(
                onClickSomething = { exercise ->
                    swipeDismissableNavController.navigate(
                        route = Screen.Exercises.route + "/{$exercise}"
                    )
                }
            )
        }

        composable(
            route = Screen.Exercises.route + "/{$TRAINING_ID_NAV_ARGUMENT}",
            arguments = listOf(
                navArgument(TRAINING_ID_NAV_ARGUMENT) {
                    type = NavType.StringType
                }
            )
        ) {
            val trainingId = it.arguments!!.getString(TRAINING_ID_NAV_ARGUMENT)

            ExercisesScreen(exercise = trainingId)
        }
    }
}