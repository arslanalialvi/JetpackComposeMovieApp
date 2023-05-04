package com.example.jetpackcomposemovieapp.screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.jetpackcomposemovieapp.model.Movie
import com.example.jetpackcomposemovieapp.model.getMovies
import com.example.jetpackcomposemovieapp.widgets.MovieRow
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailScreen(navController: NavController, movieId: String?){
    val movieNewList= getMovies().filter {
        movie ->
        movie.id== movieId
    }
    val context= LocalContext.current
    val coroutineScope= rememberCoroutineScope()
    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.Transparent, elevation = 0.dp) {
            Row(horizontalArrangement = Arrangement.Start) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "back arrow",
                modifier = Modifier.clickable { navController.popBackStack() })
                Spacer(modifier = Modifier.width(100.dp))
                Text(text = "Movies")
            }

        }
    }) {
          Surface(modifier = Modifier
              .fillMaxWidth()
              .fillMaxHeight()
              .padding(22.dp)) {
        Column(verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally) {
            MovieRow(movie = movieNewList[0]){
                coroutineScope.launch {
                    Toast.makeText(context,"Movie Id ${it}",Toast.LENGTH_LONG).show()

                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Divider()
            Text(text = "Movie Images")
            HorizontalScollableImageView(movieNewList)

        }
    }

        
    }
}

@Composable
private fun HorizontalScollableImageView(movieNewList: List<Movie>) {
    LazyRow {
        items(movieNewList.first().images) { image ->
            Card(modifier = Modifier
                .padding(12.dp)
                .size(240.dp), elevation = 5.dp) {
                AsyncImage(
                    model = image,
                    contentDescription = null
                )
            }
        }
    }
}