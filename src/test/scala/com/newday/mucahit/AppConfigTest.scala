package com.newday.mucahit

import org.scalatest.{FunSuite, Matchers}

class AppConfigTest extends FunSuite with Matchers {

  test("it should successfully construct when parameters are provided") {
    val inputPath1 = "inputPath1"
    val outputPath1 = "outputPath1"
    val inputPath2 = "inputPath2"
    val outputPath2 = "outputPath2"
    val delimiter="::"
    val conf = AppConfig(inputPath1, outputPath1, inputPath2, outputPath2,delimiter)
    conf.moviesInputPath shouldBe Some(inputPath1)
    conf.moviesOutputPath shouldBe Some(outputPath1)
    conf.ratingsInputPath shouldBe Some(inputPath2)
    conf.ratingsOutputPath shouldBe Some(outputPath2)
    conf.delimiter shouldBe delimiter
  }

  test("isValid should return true when fields are provided"){
    val inputPath1 = "inputPath1"
    val outputPath1 = "outputPath1"
    val inputPath2 = "inputPath2"
    val outputPath2 = "outputPath2"
    val delimiter="::"
    val conf = AppConfig(inputPath1, outputPath1, inputPath2, outputPath2,delimiter)
    conf.isValid shouldBe true
  }

  test("isValid should return false when any field is not provided"){
    val conf=AppConfig(Some(" "),Some("path1"))
    conf.isValid shouldBe false
  }
}
