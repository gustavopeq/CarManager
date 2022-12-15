package gustavo.projects.carmanager.navigation.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import gustavo.projects.carmanager.R
import gustavo.projects.carmanager.home.HomeScreen
import gustavo.projects.carmanager.navigation.Screen

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
}
