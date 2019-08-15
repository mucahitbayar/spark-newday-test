package com.newday.mucahit

import org.scalatest.{FunSuite, Matchers}

class AppConfigBuilderTest extends FunSuite with Matchers {

  def toShortArgs(path1: String, savePath1: String, path2: String, savePath2: String,delimiter:String) = Array(
    s"-${AppConfigBuilder.Fields.moviesInputPath.short}", path1,
    s"-${AppConfigBuilder.Fields.moviesOutputPath.short}", savePath1,
    s"-${AppConfigBuilder.Fields.ratingsInputPath.short}", path2,
    s"-${AppConfigBuilder.Fields.ratingsOutputPath.short}", savePath2,
    s"-${AppConfigBuilder.Fields.delimiter.short}", delimiter
  )

  def toLongArgs(path1: String, savePath1: String, path2: String, savePath2: String,delimiter:String) = Array(
    s"--${AppConfigBuilder.Fields.moviesInputPath.full}", path1,
    s"--${AppConfigBuilder.Fields.moviesOutputPath.full}", savePath1,
    s"--${AppConfigBuilder.Fields.ratingsInputPath.full}", path2,
    s"--${AppConfigBuilder.Fields.ratingsOutputPath.full}", savePath2,
    s"--${AppConfigBuilder.Fields.delimiter.full}", delimiter
  )

  test("build should successfully construct config when parameters provided in short") {
    val inputPath1 = "inputPath1"
    val outputPath1 = "outputPath1"
    val inputPath2 = "inputPath2"
    val outputPath2 = "outputPath2"
    val delimiter="::"
    val conf = AppConfig(inputPath1, outputPath1, inputPath2, outputPath2,delimiter)
    val args = toShortArgs(inputPath1, outputPath1, inputPath2, outputPath2,delimiter)
    val builder = AppConfigBuilder()
    val actual = builder.build(args)
    actual.isSuccess shouldBe true
    val result = actual.get
    result shouldBe conf
  }

  test("build should successfully construct config when parameters provided in long format") {
    val inputPath1 = "inputPath1"
    val outputPath1 = "outputPath1"
    val inputPath2 = "inputPath2"
    val outputPath2 = "outputPath2"
    val delimiter="::"
    val conf = AppConfig(inputPath1, outputPath1, inputPath2, outputPath2,delimiter)
    val args = toLongArgs(inputPath1, outputPath1, inputPath2, outputPath2,delimiter)
    val builder = AppConfigBuilder()
    val actual = builder.build(args)
    actual.isSuccess shouldBe true
    val result = actual.get
    result shouldBe conf
  }

}
