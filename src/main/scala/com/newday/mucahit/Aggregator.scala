package com.newday.mucahit

import org.apache.spark.sql.{DataFrame, Dataset, Row}
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions.{avg, col, max, min, row_number}

object Aggregator {
  def rank(df: DataFrame, top: Int): Dataset[Row] = {
    import df.sparkSession.implicits._
    df
      .withColumn(
        "rank",
        row_number()
          .over(Window.partitionBy(col(Fields.RatingFields.userId)).orderBy(col(Fields.RatingFields.rating).desc))
      )
      .where($"rank" <= top)
  }

  def aggregate(df: DataFrame): DataFrame = {
    df
      .groupBy(Fields.MovieFields.movieId, Fields.MovieFields.title, Fields.MovieFields.genres)
      .agg(
        min(Fields.RatingFields.rating).as(Fields.AggregatedRatingFields.minRating),
        max(Fields.RatingFields.rating).as(Fields.AggregatedRatingFields.maxRating),
        avg(Fields.RatingFields.rating).as(Fields.AggregatedRatingFields.avgRating)
      )
  }
}
