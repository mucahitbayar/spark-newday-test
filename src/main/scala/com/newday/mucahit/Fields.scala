package com.newday.mucahit

object Fields {

  object MovieFields {
    val movieId: String = "MovieID"
    val title: String = "Title"
    val genres: String = "Genres"
    val fields = Seq(movieId, title, genres)
  }

  object RatingFields {
    val userId: String = "UserID"
    val movieId: String = "MovieID"
    val rating: String = "Rating"
    val timeStamp: String = "Timestamp"
    val fields = Seq(userId, movieId, rating, timeStamp)
  }

  object AggregatedRatingFields{
    val minRating: String = "minRating"
    val maxRating: String = "maxRating"
    val avgRating: String = "avgRating"
  }

}
