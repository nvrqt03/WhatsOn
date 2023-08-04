package com.example.whatson.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.whatson.screens.Homescreen

@Composable
fun MovieNavigation() {
  val navController = rememberNavController() // make sure to add dependency androidx.navigation:navigation-compose:version
  NavHost(navController = navController, startDestination = MovieScreens.HomeScreen.name) {
    composable(MovieScreens.HomeScreen.name) {
      Homescreen(navController = navController)
    }
  }
}