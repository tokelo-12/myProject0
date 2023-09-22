package com.example.librarycheckin

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.librarycheckin.checkinspage.CheckInScreen
import com.example.librarycheckin.home.HomeScreen
import com.example.librarycheckin.registrationform.RegScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    NavHost(
        navController = navController ,
        startDestination = Home.route,
        modifier = modifier
    ){
        //builder parameter
        composable(route = Home.route){
            HomeScreen()
        }

        composable(route = CheckIns.route){
            CheckInScreen()
        }

        composable(route = RegForm.route){
            RegScreen()
        }
    }

}