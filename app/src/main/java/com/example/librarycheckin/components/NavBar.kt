package com.example.librarycheckin.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LibraryAddCheck
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.librarycheckin.CheckIns
import com.example.librarycheckin.Home
import com.example.librarycheckin.ui.theme.LibraryCheckInTheme

@Composable
fun NavBar(
    navController: NavController//(Destinations) -> Unit,){}
){
    androidx.compose.material.BottomAppBar(
        modifier = Modifier
            .clip(RoundedCornerShape(15.dp)),
        cutoutShape = CircleShape,
        backgroundColor = Color.LightGray,
        contentColor = Color.Black,
    ) {
        NavigationBarItem(
            selected = false,
            onClick = {
                navController.navigate(Home.route)
//                {
//                launchSingleTop = true
//                }
                      },
            icon = {
                Icon(Icons.Default.Home, contentDescription = null)
            }
        )

        NavigationBarItem(
//            modifier = Modifier.padding(start = 16.dp),
            selected = false,
            onClick = { /*TODO*/ },
            icon = {
//                Icon(Icons.Default.Home, contentDescription = null)
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = {
                navController.navigate(CheckIns.route)
//                {
//                    launchSingleTop = true
//                }
            },
            icon = {
                Icon(Icons.Default.LibraryAddCheck, contentDescription = null)
            }
        )
    }
}

@Preview
@Composable
fun NavBarPreview(){
    LibraryCheckInTheme {
        NavBar(navController = rememberNavController())
    }
}
