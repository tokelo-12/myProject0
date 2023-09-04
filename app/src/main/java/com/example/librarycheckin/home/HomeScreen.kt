package com.example.librarycheckin.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.librarycheckin.components.Grid
import com.example.librarycheckin.ui.theme.LibraryCheckInTheme

@Composable
fun HomeScreen(){
    Column(
        Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Grid()
    }
}

@Preview
@Composable
fun GridPreview(){
    LibraryCheckInTheme {
        HomeScreen()
    }
}