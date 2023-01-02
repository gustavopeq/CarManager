package gustavo.projects.carmanager.navigation.screens

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import gustavo.projects.carmanager.addvehicle.AddVehicleScreen
import gustavo.projects.carmanager.navigation.ScreenUI
import gustavo.projects.carmanager.startup.ui.Startup

class StartupScreenUI : ScreenUI {

    @Composable
    override fun UI(navController: NavController, navArguments: Bundle?) {
        Startup(
            openAddVehicle = {
               navController.navigate(AddVehicleScreen.route()) {
                   popUpTo(0)
               }
            }
        )
    }
}