package com.newday.mucahit

import org.apache.spark.sql.SparkSession

import scala.util.{Failure, Success}

object SparkApp {
  def main(args: Array[String]): Unit = {
    AppConfigBuilder().build(args) match {
      case Success(conf) if conf.isValid =>
        val spark = SparkSession
          .builder()
          .appName("NewDay Interview")
          .master("local[*]")
          .getOrCreate()

        val dataReader = new DataReader()
        val movies = dataReader.read(spark, conf.moviesInputPath.get, conf.delimiter, Fields.MovieFields.fields)
        val ratings = dataReader.read(spark, conf.ratingsInputPath.get, conf.delimiter, Fields.RatingFields.fields)
        movies.write.parquet(conf.moviesOutputPath.get)
        ratings.write.parquet(conf.ratingsOutputPath.get)


        val joinedDF = movies.join(ratings, Fields.MovieFields.movieId)

        val movieRatings = Aggregator.aggregate(joinedDF)

        val topRatingsDF = Aggregator.rank(joinedDF,3)


      case Failure(exception) =>
        throw new Exception(exception)
    }
  }


}
