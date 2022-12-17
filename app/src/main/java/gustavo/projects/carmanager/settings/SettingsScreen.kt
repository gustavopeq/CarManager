package gustavo.projects.carmanager.settings

import gustavo.projects.carmanager.navigation.Screen

object SettingsScreen : Screen {
    private const val SETTINGS_ROUTE = "settings"
    override fun route(): String = SETTINGS_ROUTE
}