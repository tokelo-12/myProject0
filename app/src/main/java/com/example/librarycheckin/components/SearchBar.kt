package com.example.librarycheckin.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Search() {
    var text by remember { mutableStateOf("") }
    var active by remember {
        mutableStateOf(false)
    }

    val items = remember{
        mutableStateListOf(
            "User 1",
            "User2"
        )
    }
    SearchBar(
        modifier = Modifier.fillMaxWidth(),
        query = text,
        onQueryChange = {text = it},
        onSearch = {
            items.add(text)
            active = false
            text = ""  //clear after pressing the search button
        },
        active = active,

        //when search bar is clicked
        onActiveChange = {
            active = it
        },
        placeholder = {
            Text(text = "Search")
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search ,
                contentDescription = "Search Icon"
            )
        },
        trailingIcon = {
            if(active) {
                Icon(

                    modifier = Modifier.clickable {
                        if(text.isNotEmpty()){
                            text = ""
                        }else{
                            active = false
                        }

                    },
                    imageVector = Icons.Default.Close,
                    contentDescription = "Search close button"
                )
            }
        }
    ) {
        items.forEach {
            Row (modifier = Modifier.padding(all = 10.dp)){
                Icon(
                    imageVector = Icons.Default.History ,
                    contentDescription = "History Icon"
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = it)
            }
        }
    }
}