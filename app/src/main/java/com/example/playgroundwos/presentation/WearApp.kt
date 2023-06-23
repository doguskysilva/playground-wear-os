package com.example.playgroundwos.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.wear.compose.material.Scaffold
import androidx.wear.compose.navigation.currentBackStackEntryAsState
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import com.example.playgroundwos.presentation.navigation.NavigationGraph
import com.example.playgroundwos.presentation.theme.PlaygroundWOSTheme

@Composable
fun WearApp(
    modifier: Modifier = Modifier,
    swipeDismissableNavController: NavHostController = rememberSwipeDismissableNavController()
) {
    val currentBackStackEntry by swipeDismissableNavController.currentBackStackEntryAsState()

//    val scrollType =
//        currentBackStackEntry?.arguments?.getSerializable(SCROLL_TYPE_NAV_ARGUMENT)
//            ?: DestinationScrollType.NONE


    PlaygroundWOSTheme {
        Scaffold(
            modifier = modifier
        ) {
            NavigationGraph(swipeDismissableNavController = swipeDismissableNavController)
        }
    }
}