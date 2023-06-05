package com.example.whatson

import android.graphics.drawable.Icon
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.whatson.ui.theme.WhatsOnTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MyApp {
        MainContent()
      }
    }
  }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
  WhatsOnTheme {
    Scaffold(topBar = {
      TopAppBar(backgroundColor = Color.Magenta, elevation = 5.dp) {
        Text(text = "What's On")
      }
    }) {
      content()
      it.calculateBottomPadding()
    }
  }
}

@Composable
fun MainContent(movieList: List<String> = listOf(
  "Avatar 2",
  "The Batman",
  "Twilight: Breaking Dawn",
  "Dungeons & Dragons",
  "Extraction 2",
  "John Wick 4",
  "65"
)) {
  Column(modifier = Modifier.padding(12.dp)) {
    LazyColumn {
      items(items = movieList) {
        MovieRow(movie = it) {movie ->
          Log.d("TAG", "MainContent: $movie")
        }
      }
    }
  }

}

@Composable
fun MovieRow(movie: String, onItemClick: (String) -> Unit = {}) {
  Card(modifier = Modifier
    .padding(4.dp)
    .fillMaxWidth()
    .height(130.dp)
    .clickable {
      onItemClick(movie)
    },
    shape = RoundedCornerShape(corner = CornerSize(16.dp)),
    elevation = 6.dp
    ) {
    Row(verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.Start) {
      Surface(modifier = Modifier
        .padding(12.dp)
        .size(100.dp),
      shape = RectangleShape,
      elevation = 4.dp) {
        Icon(
          imageVector = Icons.Default.AccountBox,
          contentDescription = "Movie Image"
        )
      }
      Text(text = movie)
    }
  }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  MyApp {
    MainContent()
  }
}