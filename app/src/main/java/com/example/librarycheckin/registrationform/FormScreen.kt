package com.example.librarycheckin.registrationform

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.librarycheckin.components.Form
import com.example.librarycheckin.ui.theme.LibraryCheckInTheme

@Composable
fun RegScreen() {
    var text by rememberSaveable {
        mutableStateOf("")
    }
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        ) {
        item {
            Form()
        }

    }
}

@Preview
@Composable
fun RegFormPreview(){
    LibraryCheckInTheme {
        Surface() {
            RegScreen()
        }
    }
}