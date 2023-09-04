package com.example.librarycheckin.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
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
//    val user = UserData.findUserById(979557563673753)
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

@Composable
fun FAB(){
    FloatingActionButton(onClick = { /*TODO*/ },backgroundColor = Color.LightGray, contentColor = Color.Black) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = null
        )
    }
}

@Composable
fun Grid(modifier : Modifier = Modifier.size(200.dp)
) {
    LazyVerticalGrid(
        GridCells.Fixed(2),
//        modifier = Modifier
//            .heightIn(200.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)

    ) {
        item {
            Card(
                modifier = modifier
//                    .fillMaxWidth()
//                    .size(200.dp)
//                    .padding(8.dp),
//                contentAlignment = Alignment.Center
            ) {
//                Text(text = numbers.toString())
            }
        }

        item {
            Card(
                modifier = modifier
//                    .fillMaxWidth()
//                    .size(200.dp)
//                    .padding(8.dp),
            ){
//                Text(text = numbers.toString())
            }
        }


        item {
            Card(
                modifier = modifier
//                    .fillMaxWidth()
//                    .size(200.dp)
//                    .padding(8.dp),
            ){
//                Text(text = numbers.toString())
            }
        }

        item {
            Card(
                modifier = modifier
//                    .fillMaxWidth()
//                    .size(200.dp)
//                    .padding(8.dp),
            ){
//                Text(text = numbers.toString())
            }
        }
    }
}


//@Preview
//@Composable
//fun GridPreview(){
//    LibraryCheckInTheme {
//        Grid()
//    }
//}