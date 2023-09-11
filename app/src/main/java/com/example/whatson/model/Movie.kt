package com.example.whatson.model

data class Movie(
  val id: String,
  val title: String,
  val year: String,
  val genre: String,
  val director: String,
  val actors: String,
  val plot: String,
  val poster: String,
  val images: List<String>,
  val rating: String,
)

fun getMovies(): List<Movie> {
  return listOf()
}
