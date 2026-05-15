package com.yeldar.ch4

import android.R.attr.text
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yeldar.ch4.ui.theme.Ch4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ch4Theme {
                Scaffold(
                    topBar = { PacktCenterAlignedTopBar() },
                    bottomBar = { PacktBottomNavigationBar() },
                    floatingActionButton = { PacktFloatingActionButton() },
                    content = { paddingValues ->
                        Column(
                            modifier = Modifier.fillMaxSize()
                                .padding(paddingValues)
                                .background(Color.Gray.copy(alpha = 0.1f)),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                modifier = Modifier.padding(10.dp),
                                text = "Mastering Kotlin for Android Development",
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Ch4Theme {
        Greeting("Android")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PacktCenterAlignedTopBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(text = "Packt publishing")
        }
    )
}

@Composable
fun PacktFloatingActionButton() {
    ExtendedFloatingActionButton(
        onClick = {},
        content = {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "New Chat"
            )
//            Text(
//                modifier = Modifier.padding(10.dp),
//                text = "New Chat"
//            )
        }
    )
}

@Composable
fun PacktBottomNavigationBar() {
    BottomAppBar {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = Icons.Rounded.Home,
                contentDescription = "Home Screen"
            )

            Icon(
                imageVector = Icons.Rounded.ShoppingCart,
                contentDescription = "Cart Screen"
            )

            Icon(
                imageVector = Icons.Rounded.AccountCircle,
                contentDescription = "Account Screen"
            )
        }
    }
}