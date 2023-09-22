package com.example.librarycheckin.checkinspage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.librarycheckin.components.BaseRow
import com.example.librarycheckin.components.CheckInsRow
import com.example.librarycheckin.data.UserData
import com.example.librarycheckin.ui.theme.LibraryCheckInTheme

@Composable
fun <T> UserCollection(
    items: List<T>,
    rows:@Composable (T) -> Unit
){
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
        ){
        item{
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(10.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                ) {
                    items.forEach { item ->
                        Card(
                            shape = RoundedCornerShape(0.dp),
                            modifier = Modifier.fillMaxWidth()
                        ){
                            ListItem(
                                modifier = Modifier.fillMaxWidth(),
                                headlineContent = { rows(item)},
                                leadingContent = {
                                    Icon(
                                        Icons.Filled.Favorite,
                                        contentDescription = "Localized description",
                                    )
                                }
                            )
                        }

                    }
                }
            }
        }
    }


@Composable
fun CheckInScreen(){
    UserCollection(
        items = UserData.usersList,
        rows = { user ->
            CheckInsRow(
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
