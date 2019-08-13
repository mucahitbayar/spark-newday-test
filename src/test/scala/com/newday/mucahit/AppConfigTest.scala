package com.newday.mucahit

import org.scalatest.{FunSuite, Matchers}

class AppConfigTest extends FunSuite with Matchers {

  test("it should successfully construct when parameters are provided") {
    val path1 = Some("path1")
    val path2 = Some("path2")
    val conf=AppConfig(path1,path2)
    conf.moviesFilePath shouldBe path1
    conf.ratingsFilePath shouldBe path2
  }

}
