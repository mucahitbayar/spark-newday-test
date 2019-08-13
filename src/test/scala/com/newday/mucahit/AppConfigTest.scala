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

  test("isValid should return true when fields are provided"){
    val conf=AppConfig(Some("path1"),Some("path1"))
    conf.isValid shouldBe true
  }

  test("isValid should return false when any field is not provided"){
    val conf=AppConfig(Some(" "),Some("path1"))
    conf.isValid shouldBe false
  }
}
