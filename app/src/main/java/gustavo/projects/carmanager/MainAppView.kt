package gustavo.projects.carmanager

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import gustavo.projects.carmanager.navigation.MainNavGraph
import gustavo.projects.carmanager.navigation.components.MainNavBar
import gustavo.projects.carmanager.navigation.components.MainNavBarItem
import gustavo.projects.carmanager.startup.StartupScreen
import gustavo.projects.carmanager.theme.CarManagerTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainApp() {
    CarManagerTheme {

        val navController = rememberNavController()
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val navItems = mainNavBarItems

        Scaffold(
            bottomBar = {
                if (!mainNavBarDisabledScreens.contains(navBackStackEntry?.destination?.route)) {
                    MainNavBar(navBarItems = navItems, navController = navController)
                }
            },
            content = {
               Box(modifier = Modifier.padding(it)) {
                   MainNavGraph(navController)
               }
            },
        )
    }
}

private val mainNavBarItems = listOf<MainNavBarItem>(
    MainNavBarItem.Home,
    MainNavBarItem.Info,
    MainNavBarItem.Settings
)

private val mainNavBarDisabledScreens = listOf(
    StartupScreen.route()
)