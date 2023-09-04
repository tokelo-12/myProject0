package com.example.librarycheckin.checkinspage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.librarycheckin.components.BaseRow
import com.example.librarycheckin.data.UserData
import com.example.librarycheckin.ui.theme.LibraryCheckInTheme

@Composable
fun <T> UserCollection(
    items: List<T>,
    rows:@Composable (T) -> Unit
){
    LazyColumn{
        item {
            Card(

            ) {
                Column(modifier = Modifier.padding(10.dp)) {
                    items.forEach { item ->
                        rows(item)
                    }
                }
            }
        }
    }

}
@Composable
fun CheckInScreen(
){
    UserCollection(
        items = UserData.usersList,
        rows = { user ->
            BaseRow(
                time = user.date,
                firstName = user.firstName,
                lastName = user.lastName,
                laptopMake = user.laptopMake
            )
        }
    )
}



@Preview
@Composable
fun CheckInsScreenPreview(){
    LibraryCheckInTheme {
        CheckInScreen()
    }
}
