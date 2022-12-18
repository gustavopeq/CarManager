package gustavo.projects.carmanager.startup

import gustavo.projects.carmanager.navigation.Screen

object StartupScreen : Screen {

    private const val STARTUP_ROUTE = "startup"
    override fun route(): String = STARTUP_ROUTE
}