package com.example.librarycheckin.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.Computer
import androidx.compose.material.icons.filled.Tag
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.librarycheckin.ui.theme.LibraryCheckInTheme

@Composable
fun Form(){
    var text by rememberSaveable {
        mutableStateOf("")
    }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = text,
                onValueChange = {text = it},
                label = { Text(text = "First Name") },
                leadingIcon = { Icon(Icons.Default.AccountCircle, contentDescription = null) }
            )
            TextField(
                value = text,
                onValueChange = {text = it},
                label = { Text(text = "Last Name") },
                leadingIcon = { Icon(Icons.Default.AccountCircle, contentDescription = null) }
            )

            TextField(
                value = text,
                onValueChange = {text = it},
                label = { Text(text = "Laptop Brand") },
                leadingIcon = { Icon(Icons.Default.Computer, contentDescription = null) }
            )

            TextField(
                value = text,
                onValueChange = {text = it},
                label = { Text(text = "Device ID") },
                leadingIcon = { Icon(Icons.Default.Tag, contentDescription = null) }
            )

            TextField(
                value = text,
                onValueChange = {text = it},
                label = { Text(text = "Identification") },
                leadingIcon = { Icon(Icons.Default.Badge, contentDescription = null) }
            )

    }
}

@Preview
@Composable
fun FormPreview(){
    LibraryCheckInTheme {
        Surface {
            Form()
        }
    }
}