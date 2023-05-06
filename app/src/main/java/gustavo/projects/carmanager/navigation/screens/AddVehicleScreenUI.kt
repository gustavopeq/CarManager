package gustavo.projects.carmanager.navigation.screens

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import gustavo.projects.carmanager.addvehicle.ui.AddVehicle
import gustavo.projects.carmanager.home.HomeScreen
import gustavo.projects.carmanager.navigation.ScreenUI

class AddVehicleScreenUI : ScreenUI {

    @Composable
    override fun UI(navController: NavController, navArguments: Bundle?) {
        AddVehicle(
            goToHome = {
                navController.navigate(HomeScreen.route())
            }
        )
    }
}