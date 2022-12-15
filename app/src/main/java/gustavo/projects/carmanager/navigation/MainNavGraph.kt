package gustavo.projects.carmanager.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import gustavo.projects.carmanager.home.HomeScreen
import gustavo.projects.carmanager.navigation.screens.HomeScreenUI
import gustavo.projects.carmanager.navigation.util.addDestinations

private val mainNavDestinations: Map<Screen, ScreenUI> = mapOf(
    HomeScreen to HomeScreenUI()
)

@Composable
fun MainNavGraph(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = HomeScreen.route()
    ) {
        addDestinations(mainNavDestinations, navController)
    }
}