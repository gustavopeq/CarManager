package gustavo.projects.carmanager.navigation.screens

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import gustavo.projects.carmanager.info.ui.VehicleInfo
import gustavo.projects.carmanager.navigation.ScreenUI

class InfoScreenUI : ScreenUI {

    @Composable
    override fun UI(navController: NavController, navArguments: Bundle?) {
        VehicleInfo()
    }
}