package com.example.librarycheckin.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.librarycheckin.Destinations
import com.example.librarycheckin.RegForm
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
    fun CheckInsRow(
    time: LocalDateTime,
    firstName: String,
    lastName: String,
    laptopMake: String
    ){
    val horizontalArr = Arrangement.spacedBy(20.dp)
    BaseRow(
        time = time,
        firstName = firstName,
        lastName = lastName,
        laptopMake = laptopMake,
        horizontalArr = horizontalArr
    )
}

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
    laptopMake: String,
    horizontalArr: Arrangement.Horizontal
){
//    val user = UserData.findUserById(979557563673753)
    val name = "$firstName $lastName"
    val formattedTime = formatTime(time)

    Row(
        modifier = Modifier
            .fillMaxWidth(),
//            .align(Alignment.CenterHorizontally),
        horizontalArrangement = horizontalArr,
        verticalAlignment = Alignment.CenterVertically,
    ){
        Text(text = formattedTime)
        Text(text = name)
        Text(text = laptopMake)
    }
}

@Composable
fun FAB(
    go: (Destinations) -> Unit,
){
    FloatingActionButton(
        onClick = { go(RegForm) },
        backgroundColor = Color.Black,
        contentColor = Color.White,
        ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = null,
            tint = Color.White
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
        horizontalArrangement = Arrangement.spacedBy(10.dp),

    ) {
        item {
            Card(
                modifier = modifier,
//                    .fillMaxWidth()
//                    .size(200.dp)
//                    .padding(8.dp),
//                contentAlignment = Alignment.Center
                colors = CardDefaults.cardColors(
                    containerColor = Color.Black,
//                    contentColor = Color.White,
//                    disabledContainerColor = Color.White,
//                    disabledContentColor = Color.White
                ),

                ) {
//                Text(text = numbers.toString())
            }
        }

        item {
            Card(
                modifier = modifier,
//                    .fillMaxWidth()
//                    .size(200.dp)
//                    .padding(8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Black,
//                    contentColor = Color.White,
//                    disabledContainerColor = Color.White,
//                    disabledContentColor = Color.White
                ),

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
                ,
                colors = CardDefaults.cardColors(
                    containerColor = Color.Black,
//                    contentColor = Color.White,
//                    disabledContainerColor = Color.White,
//                    disabledContentColor = Color.White
                ),

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
                ,
                colors = CardDefaults.cardColors(
                    containerColor = Color.Black,
//                    contentColor = Color.White,
//                    disabledContainerColor = Color.White,
//                    disabledContentColor = Color.White
                )
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