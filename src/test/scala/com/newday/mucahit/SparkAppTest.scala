package com.newday.mucahit

import java.nio.file.{Files, Paths}

import org.scalatest.{FunSuite, Matchers}

class SparkAppTest extends FunSuite with Matchers {

  test("testMain") {
    val saveDir = s"target/${java.util.UUID.randomUUID().toString}"
    val moviesInputPath = getClass.getResource("/ml-1m/movies.dat").getPath
    val ratingsInputPath = getClass.getResource("/ml-1m/ratings.dat").getPath
    val moviesOutputPath = s"${saveDir}/movies"
    val ratingsOutputPath = s"${saveDir}/ratings"
    val delimiter = "::"
    val args = Array(
      s"--${AppConfigBuilder.Fields.moviesInputPath.full}", moviesInputPath,
      s"--${AppConfigBuilder.Fields.moviesOutputPath.full}", moviesOutputPath,
      s"--${AppConfigBuilder.Fields.ratingsInputPath.full}", ratingsInputPath,
      s"--${AppConfigBuilder.Fields.ratingsOutputPath.full}", ratingsOutputPath,
      s"--${AppConfigBuilder.Fields.delimiter.full}", delimiter
    )
    SparkApp.main(args)

    Files.exists(Paths.get(s"${moviesOutputPath}/_SUCCESS")) shouldBe true
    Files.exists(Paths.get(s"${moviesOutputPath}/_SUCCESS")) shouldBe true
  }

}
