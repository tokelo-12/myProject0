package com.example.librarycheckin

interface Destinations{
    val route: String
}

object Home: Destinations{
    override val route = "home"
}

object CheckIns: Destinations{
    override val route = "checkIns"
}

