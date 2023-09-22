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
import androidx.compose.ui.unit.dp
import com.example.librarycheckin.CheckIns
import com.example.librarycheckin.Destinations
import com.example.librarycheckin.Home

@Composable
fun NavBar(
    go: (Destinations) -> Unit
){


    androidx.compose.material.BottomAppBar(
        modifier = Modifier
            .clip(RoundedCornerShape(15.dp)),
        cutoutShape = CircleShape,
        contentColor = Color.Black,
        backgroundColor = Color.White,
        ) {
        NavigationBarItem(
            selected = false,
            onClick = { go(Home) },
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
            onClick = { go(CheckIns) },
            icon = {
                Icon(Icons.Default.LibraryAddCheck, contentDescription = null)
            }
        )
    }
}

//@Preview
//@Composable
//fun NavBarPreview(){
//    LibraryCheckInTheme {
//        NavBar(navController = rememberNavController())
//    }
//}
