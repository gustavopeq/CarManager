package gustavo.projects.carmanager.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import gustavo.projects.carmanager.home.HomeScreen
import gustavo.projects.carmanager.info.InfoScreen
import gustavo.projects.carmanager.navigation.screens.HomeScreenUI
import gustavo.projects.carmanager.navigation.screens.InfoScreenUI
import gustavo.projects.carmanager.navigation.screens.SettingsScreenUI
import gustavo.projects.carmanager.navigation.util.addDestinations
import gustavo.projects.carmanager.settings.SettingsScreen

private val mainNavDestinations: Map<Screen, ScreenUI> = mapOf(
    HomeScreen to HomeScreenUI(),
    InfoScreen to InfoScreenUI(),
    SettingsScreen to SettingsScreenUI()
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