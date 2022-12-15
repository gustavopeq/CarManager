package gustavo.projects.carmanager.navigation.util

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import gustavo.projects.carmanager.navigation.Screen
import gustavo.projects.carmanager.navigation.ScreenUI

fun NavGraphBuilder.addDestinations(
    destinations: Map<Screen, ScreenUI>,
    navController: NavController
) {
    destinations.forEach { entry ->
        val screen = entry.key
        composable(screen.route(), screen.arguments) {
            entry.value.UI(navController = navController, navArguments = it.arguments)
        }
    }
}