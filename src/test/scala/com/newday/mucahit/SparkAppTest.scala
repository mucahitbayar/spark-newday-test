package com.newday.mucahit

import org.scalatest.FunSuite

class SparkAppTest extends FunSuite {

  test("testMain") {
    val path1=getClass.getResource("/ml-1m/movies.dat").getPath
    val path2=getClass.getResource("/ml-1m/ratings.dat").getPath
    val args = Array(s"--${AppConfigBuilder.Fields.moviesFilePath.full}", path1, s"--${AppConfigBuilder.Fields.ratingsFilePath.full}", path2)
    SparkApp.main(args)
  }

}
