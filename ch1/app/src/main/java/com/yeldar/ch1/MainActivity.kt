package com.yeldar.ch1

import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.yeldar.ch1.ui.theme.Ch1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ch1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                    Column()
//                    Row()
//                    Notification()
//                    LColumn(modifier = Modifier.padding(innerPadding))
//                    Column(
//                        Modifier.padding(innerPadding).fillMaxSize(),
//                        horizontalAlignment = Alignment.CenterHorizontally,
//                        verticalArrangement = Arrangement.SpaceAround
//                    ) {
//                        LRow(modifier = Modifier.weight(1f))
//                        LColumn(modifier = Modifier.weight(1f))
//                        LColumn(modifier = Modifier.weight(1f))
//                        LVGrid(modifier = Modifier.weight(1f))
//                        LHGrid(modifier = Modifier.weight(1f))
//                    }
                    CLayout(modifier = Modifier.padding(innerPadding))
                }
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
    Ch1Theme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
//            LRow(modifier = Modifier.padding(1.dp))
//            LColumn(modifier = Modifier.padding(1.dp).weight(1f))
//            LColumn(modifier = Modifier.padding(1.dp).weight(1f))
//            LVGrid(modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun Column() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("C-Android")
        Text("C-Kotlin")
        Text("C-Compose")
    }
}

@Composable
fun Row() {
    Row(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text("R-Android")
        Text("R-Kotlin")
        Text("R-Compose")
    }
}

@Composable
fun Notification() {
    Box(
        modifier = Modifier.size(100.dp),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.size(80.dp),
            imageVector = Icons.Outlined.Notifications,
            contentDescription = null,
            tint = Color.Green
        )
        Text(text = "9")
    }
}

@Composable
fun LRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Blue)
    ) {
        items(100) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = "Item number: $it"
            )
        }
    }
}

@Composable
fun LColumn(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Green)
    ) {
        items(100) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = "Item number: $it"
            )
        }
    }
}

@Composable
fun LVGrid(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Red),
        columns = GridCells.Fixed(3)
    ) {
        items(100) {
            Text(
                modifier = Modifier.padding(6.dp),
                text = "Item number $it"
            )
        }
    }
}

@Composable
fun LHGrid(modifier: Modifier = Modifier) {
    LazyHorizontalGrid(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Yellow),
        rows = GridCells.Fixed(3)
    ) {
        items(100) {
            Text(
                modifier = Modifier.padding(6.dp),
                text = "Item number $it"
            )
        }
    }
}

@Composable
fun CLayout(modifier: Modifier = Modifier) {
    ConstraintLayout(
       modifier = modifier
    ) {
        val (icon, text) = createRefs()

        Icon(
            modifier = Modifier.size(80.dp)
                .constrainAs(icon) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                },
            imageVector = Icons.Outlined.Notifications,
            contentDescription = null,
            tint = Color.Green
        )
        Text(
            modifier = Modifier
                .constrainAs(text) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(icon.end)
                },
            text = "9",
            style = MaterialTheme.typography.titleLarge
        )
    }
}