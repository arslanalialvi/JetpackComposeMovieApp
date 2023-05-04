package com.example.jetpackcomposemovieapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposemovieapp.navigations.MovieNavigation
import com.example.jetpackcomposemovieapp.screens.HomeScreen
import com.example.jetpackcomposemovieapp.ui.theme.JetpackComposeMovieAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
    MyApp {
        Text(text = "Hello Android")
    }
        }
    }
}
@Composable
fun MyApp(content: @Composable ()-> Unit){
    JetpackComposeMovieAppTheme {
        MovieNavigation()
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeMovieAppTheme {
        com.example.jetpackcomposemovieapp.MyApp {
            MovieNavigation()
        }
    }
}