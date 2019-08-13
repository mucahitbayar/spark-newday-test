package com.newday.mucahit

import org.scalatest.FunSuite

class SparkAppTest extends FunSuite {

  test("testMain") {
    val saveDir = s"target/${java.util.UUID.randomUUID().toString}"
    val path1 = getClass.getResource("/ml-1m/movies.dat").getPath
    val path2 = getClass.getResource("/ml-1m/ratings.dat").getPath
    val savePath1 = s"${saveDir}/movies"
    val savePath2 = s"${saveDir}/ratings"
    val args = Array(
      s"--${AppConfigBuilder.Fields.moviesInputPath.full}", path1,
      s"--${AppConfigBuilder.Fields.moviesOutputPath.full}", savePath1,
      s"--${AppConfigBuilder.Fields.ratingsInputPath.full}", path2,
      s"--${AppConfigBuilder.Fields.ratingsOutputPath.full}", savePath2,
      s"--${AppConfigBuilder.Fields.delimiter.full}", "::"
    )
    SparkApp.main(args)
  }

}
