package com.example.jetpackcomposemovieapp.screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jetpackcomposemovieapp.model.Movie
import com.example.jetpackcomposemovieapp.model.getMovies
import com.example.jetpackcomposemovieapp.navigations.MovieScreens
import com.example.jetpackcomposemovieapp.widgets.MovieRow

@Composable
fun HomeScreen(navController: NavController){
    androidx.compose.material.Scaffold(topBar = {
        androidx.compose.material.TopAppBar(backgroundColor = Color.Transparent, elevation = 0.dp) {
            androidx.compose.material.Text(text = "Movies ")
        }
    },) {
        MainContent(navController= navController)
    }
}



@Composable
fun MainContent( movies:List<Movie> = getMovies(), modifier: Modifier=Modifier, navController: NavController){
    Column(modifier =modifier.padding(12.dp) ) {
        LazyColumn{
            items(items = movies){
                MovieRow(movie = it){
                    navController.navigate(route = MovieScreens.DetailScreen.name+"/$it")
                }
            }
        }
    }
}
