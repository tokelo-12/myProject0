package com.example.librarycheckin.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.librarycheckin.data.UserData
import com.example.librarycheckin.ui.theme.LibraryCheckInTheme
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


fun formatTime(time: LocalDateTime): String {
    val formatter = DateTimeFormatter.ofPattern("HH:mm:ss")
    return time.format(formatter)
}

@Composable
fun BaseRow(
    modifier: Modifier = Modifier,
    time: LocalDateTime,
    firstName: String,
    lastName: String,
    laptopMake: String
){
    val user = UserData.findUserById(979557563673753)
    val name = "${firstName} ${lastName}"
    val formattedTime = formatTime(time)

    Row {
        Text(text = formattedTime)
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = name)
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = laptopMake)
    }
}

