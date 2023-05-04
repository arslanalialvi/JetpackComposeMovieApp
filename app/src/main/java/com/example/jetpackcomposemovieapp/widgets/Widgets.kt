package com.example.jetpackcomposemovieapp.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.jetpackcomposemovieapp.R
import com.example.jetpackcomposemovieapp.model.Movie
import com.example.jetpackcomposemovieapp.model.getMovies

@Preview
@Composable
fun MovieRow(movie: Movie= getMovies()[0], modifier: Modifier = Modifier, onItemClick: (String)-> Unit={}){
    var expanded by remember{
        mutableStateOf(false)
    }
    Card(
        modifier
            .padding(4.dp)
            .fillMaxWidth()
            .clickable { onItemClick(movie.id) },
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),elevation = 6.dp) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start) {
            Surface(modifier= modifier
                .padding(16.dp)
                .size(80.dp), shape = RectangleShape, elevation = 4.dp) {
//                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Movie image")
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(movie.images[0])
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(coil.base.R.drawable.abc_vector_test),
                    contentDescription = stringResource(R.string.description),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.clip(CircleShape)
                )
            }
            Column(modifier=modifier.padding(4.dp)){
                Text(text = movie.title, style = MaterialTheme.typography.h6)
                Text(text = "Director: ${movie.director}", style = MaterialTheme.typography.caption)
                Text(text = "Released: ${movie.year}", style = MaterialTheme.typography.caption)
               AnimatedVisibility(visible = expanded) {
                   Column {
                       Text(buildAnnotatedString {
                           withStyle(
                               style = SpanStyle(color = Color.DarkGray, fontSize = 13.sp)){
                               append("Plot: ")
                           }
                           withStyle(style = SpanStyle(color = Color.DarkGray, fontSize = 13.sp, fontWeight = FontWeight.Bold)){
                               append(movie.plot)
                           }
                       }, modifier= modifier.padding(6.dp))
                       Divider(modifier= modifier.padding(6.dp))
                       Text(text = "Actors : ${movie.actors}", style = MaterialTheme.typography.caption)
                       Text(text = "Rating: ${movie.rating}", style = MaterialTheme.typography.caption)

                   }
               }

                Icon(imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    contentDescription = "Arrow down",
                    tint = Color.DarkGray,
                    modifier = Modifier
                        .size(25.dp)
                        .clickable { expanded = !expanded })


            }
        }
    }
}