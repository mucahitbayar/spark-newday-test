package com.newday.mucahit

import org.scalatest.{FunSuite, Matchers}

class AppConfigTest extends FunSuite with Matchers {

  test("it should successfully construct when parameters are provided") {
    val path1 = "path1"
    val path2 = "path2"
    val conf=AppConfig(path1,path2)
    conf.moviesFilePath shouldBe path1
    conf.ratingsFilePath shouldBe path2
  }

  test("it should fail when MoviesFilePath parameter is null or empty") {
      intercept[java.lang.IllegalArgumentException]{
        AppConfig("","some-path")
      }
  }

  test("it should fail when RatingsFilePath parameter is null or empty") {
    intercept[java.lang.IllegalArgumentException]{
      AppConfig("some-path","")
    }
  }

}
