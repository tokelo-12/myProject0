package com.example.librarycheckin

import androidx.compose.runtime.Composable
import com.example.librarycheckin.checkinspage.checkInScreen
import com.example.librarycheckin.home.HomeScreen

interface Destinations{
    val route: String
    val screen: @Composable () -> Unit
}

object Home: Destinations{
    override val route = "home"
    override val screen : @Composable () -> Unit = { HomeScreen() }
}

object CheckIns: Destinations{
    override val route = "checkIns"
    override val screen : @Composable () -> Unit = {checkInScreen()}

}

