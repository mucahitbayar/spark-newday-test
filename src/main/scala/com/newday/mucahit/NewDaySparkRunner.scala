package com.newday.mucahit

import org.apache.spark.sql.SparkSession

case class NewDaySparkRunner(conf:AppConfig) extends SparkRunner{
  override def run(spark: SparkSession): Unit = {
    val dataReader = new DataReader()
    val movies = dataReader.read(spark, conf.moviesInputPath.get, conf.delimiter, Fields.MovieFields.fields).cache()
    val ratings = dataReader.read(spark, conf.ratingsInputPath.get, conf.delimiter, Fields.RatingFields.fields).cache()
    movies.write.parquet(conf.moviesOutputPath.get)
    ratings.write.parquet(conf.ratingsOutputPath.get)


    val joinedDF = movies.join(ratings, Fields.MovieFields.movieId).cache()

    val movieRatings = Aggregator.aggregate(joinedDF)

    val topRatingsDF = Aggregator.rank(joinedDF,3)
  }
}
