package com.example.whatson.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.whatson.MovieRow
import com.example.whatson.navigation.MovieScreens

@Composable
fun Homescreen(navController: NavController) {
  Scaffold(
    topBar = {
      TopAppBar(backgroundColor = Color.LightGray, elevation = 5.dp) {
        Text(text = "Movie Details")
      }
    },
  ) {
    MainContent(navController = navController)
  }
}

@Composable
fun MainContent(
  navController: NavController,
  movieList: List<String> = listOf(
    "Avatar 2",
    "The Batman",
    "Twilight: Breaking Dawn",
    "Dungeons & Dragons",
    "Extraction 2",
    "John Wick 4",
    "65"
  )
) {
  Column(modifier = Modifier.padding(12.dp)) {
    LazyColumn {
      items(items = movieList) {
        MovieRow(movie = it) { movie ->
          Log.d("TAG", "MainContent: $movie")
          navController.navigate(route = MovieScreens.DetailsScreen.name + "/$movie")
        }
      }
    }
  }
}
