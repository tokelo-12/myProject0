package com.example.librarycheckin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.librarycheckin.components.FAB
import com.example.librarycheckin.components.NavBar
import com.example.librarycheckin.components.Search
import com.example.librarycheckin.ui.theme.LibraryCheckInTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LibraryCheckInTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
                ) {
                    LibraryApp()
                }
            }
        }
    }
}










@Composable
fun LibraryApp(){
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()

    //real time update of backStack as State
    val currentBackStack by navController.currentBackStackEntryAsState()

    //get destination
    val currentDestination = currentBackStack?.destination

    Scaffold(
        backgroundColor = Color.Black,
        modifier = Modifier.fillMaxSize(),
        topBar = { Search() },
        bottomBar = {
            NavBar(
                go = { newScreen ->
                    navController.navigateSingleTopTo(
                        newScreen.route
                    )
                }
            )
        },

        floatingActionButton = {
            FAB(
                go = { newScreen ->
                    navController.navigateSingleTopTo(
                        newScreen.route
                    )
                }
            )
        },
        scaffoldState = scaffoldState,
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center
    ){ innerPadding ->

        Surface(modifier = Modifier.fillMaxSize()) {
            AppNavHost(
                navController = navController,
                modifier = Modifier.padding(innerPadding)
            )
        }

    }
}



    fun NavHostController.navigateSingleTopTo(route: String) = this.navigate(route) {
//            pop up to the start destination of the graph to avoid building up a large stack of destinations on the back stack as you select tabs
            popUpTo(
                this@navigateSingleTopTo.graph.findStartDestination().id
            ){ saveState = true }
            launchSingleTop = true
            restoreState = true
        }


@Preview
@Composable
fun BottomAppPreview(){
    LibraryCheckInTheme {
        LibraryApp()
    }
}

