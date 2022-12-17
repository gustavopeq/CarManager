package gustavo.projects.carmanager.navigation.screens

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import gustavo.projects.carmanager.navigation.ScreenUI
import gustavo.projects.carmanager.settings.ui.Settings

class SettingsScreenUI: ScreenUI {

    @Composable
    override fun UI(navController: NavController, navArguments: Bundle?) {
        Settings()
    }
}