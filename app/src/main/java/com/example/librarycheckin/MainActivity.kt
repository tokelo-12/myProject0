package com.example.librarycheckin

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LibraryAddCheck
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.librarycheckin.ui.theme.LibraryCheckInTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LibraryCheckInTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

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

@Composable
fun FourSizeGrid(modifier: Modifier) {

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

//grid box size variable
val size = 200.dp


@Composable
fun NavBar(){
    androidx.compose.material.BottomAppBar(
        modifier = Modifier
//            .padding(horizontal = 5.dp)
            .clip(RoundedCornerShape(15.dp)),
        cutoutShape = CircleShape,
        backgroundColor = Color.LightGray,
        contentColor = Color.Black,
        ) {
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
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
            onClick = { /*TODO*/ },
            icon = {
                Icon(Icons.Default.LibraryAddCheck, contentDescription = null)
            }
        )
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(){
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        backgroundColor = Color.Black,
        modifier = Modifier.fillMaxSize(),
        topBar = { Search() },
        bottomBar = { NavBar() },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ },backgroundColor = Color.LightGray, contentColor = Color.Black) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
            }
        },
        scaffoldState = scaffoldState,
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center
    ){
        Column(
            Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            
            val interactionSource = remember {
                MutableInteractionSource()
            }

            val isPressed by interactionSource.collectIsPressedAsState()

            Button(
                onClick = { /*TODO*/ },
                interactionSource = interactionSource
            ) {
                Text(if (isPressed) "Pressed" else "Not pressed" )
            }

            FourSizeGrid(modifier = Modifier.size(size))
        }
    }
}

@Preview
@Composable
fun BottomAppPreview(){
    LibraryCheckInTheme {
        HomeScreen()
    }
}
@Preview
@Composable
fun NavBarPreview(){
    LibraryCheckInTheme {
        NavBar()
    }
}


@Preview(showBackground = true)
@Composable
fun DetailsSectionPreview(){
    LibraryCheckInTheme {
        FourSizeGrid(modifier = Modifier.size(size))
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    LibraryCheckInTheme {
//        Search()
//    }
//}