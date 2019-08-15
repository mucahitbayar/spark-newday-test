package com.newday.mucahit

import java.nio.file.{Files, Paths}

import com.holdenkarau.spark.testing.DataFrameSuiteBase
import org.scalatest.{FunSuite, Matchers}

class NewDaySparkRunnerTest extends FunSuite with Matchers with DataFrameSuiteBase {

  ignore("run should complete steps successfully") {
    val sqlCtx = sqlContext
    import sqlCtx.implicits._

    val saveDir = s"target/${java.util.UUID.randomUUID().toString}"
    val moviesInputPath = this.getClass.getResource("/ml-1m/movies.dat").getPath
    val ratingsInputPath = this.getClass.getResource("/ml-1m/ratings.dat").getPath
    val moviesOutputPath = s"${saveDir}/movies"
    val ratingsOutputPath = s"${saveDir}/ratings"
    val delimiter = "::"
    val conf = AppConfig(moviesInputPath, moviesOutputPath, ratingsInputPath, ratingsOutputPath, delimiter)
    NewDaySparkRunner(conf).run(spark)

    Files.exists(Paths.get(s"${moviesOutputPath}/_SUCCESS")) shouldBe true
    Files.exists(Paths.get(s"${moviesOutputPath}/_SUCCESS")) shouldBe true
    // Not completed
    // TODO: test output
    //    val dataReader = new DataReader()
    //    val moviesDF = dataReader.read(spark, moviesInputPath, delimiter, Fields.MovieFields.fields)
    //    val ratingsDF = dataReader.read(spark, ratingsInputPath, delimiter, Fields.RatingFields.fields)
    //    val savedMoviesDF = spark.read.parquet(moviesOutputPath)
    //    assertDataFrameEquals(moviesDF, savedMoviesDF)
  }

}
