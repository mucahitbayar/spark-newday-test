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

        val saveDir = java.util.UUID.randomUUID().toString

        val delimiter = "::"
        val moviesDataReader = MoviesDataReader()
        val ratingsDataReader = RatingsDataReader()
        val movies = moviesDataReader.read(spark, conf.moviesFilePath.get, delimiter)
        val ratings = ratingsDataReader.read(spark, conf.ratingsFilePath.get, delimiter)
        movies.write.parquet(s"${saveDir}/movies")
        ratings.write.parquet(s"${saveDir}/ratings")

      case Failure(exception) =>
        throw new Exception(exception)
    }
  }
}
