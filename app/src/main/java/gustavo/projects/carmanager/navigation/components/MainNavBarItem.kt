package gustavo.projects.carmanager.navigation.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import gustavo.projects.carmanager.R
import gustavo.projects.carmanager.home.HomeScreen
import gustavo.projects.carmanager.info.InfoScreen
import gustavo.projects.carmanager.navigation.Screen
import gustavo.projects.carmanager.settings.SettingsScreen

sealed class MainNavBarItem(
    val screen: Screen,
    @StringRes val labelResId: Int,
    @DrawableRes val iconResId: Int
) {
    object Home: MainNavBarItem(
        screen = HomeScreen,
        labelResId = R.string.main_nav_home,
        iconResId = R.drawable.ic_home
    )
    object Info: MainNavBarItem(
        screen = InfoScreen,
        labelResId = R.string.main_nav_info,
        iconResId = R.drawable.ic_info
    )
    object Settings: MainNavBarItem(
        screen = SettingsScreen,
        labelResId = R.string.main_nav_settings,
        iconResId = R.drawable.ic_settings
    )
}
