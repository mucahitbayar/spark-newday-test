package com.newday.mucahit

import org.scalatest.{FunSuite, Matchers}

class AppConfigBuilderTest extends FunSuite with Matchers {

  test("build should successfully construct config when parameters provided in short") {
    val path1 = "path1"
    val path2 = "path2"
    val conf = AppConfig(path1, path2)
    val args = Array(s"-${AppConfigBuilder.Fields.moviesFilePath.short}", path1, s"-${AppConfigBuilder.Fields.ratingsFilePath.short}", path2)
    val builder = AppConfigBuilder()
    val actual = builder.build(args)
    actual.isSuccess shouldBe true
    val result = actual.get
    result shouldBe conf
  }

  test("build should successfully construct config when parameters provided in long format") {
    val path1 = "path1"
    val path2 = "path2"
    val conf = AppConfig(path1, path2)
    val args = Array(s"--${AppConfigBuilder.Fields.moviesFilePath.full}", path1, s"--${AppConfigBuilder.Fields.ratingsFilePath.full}", path2)
    val builder = AppConfigBuilder()
    val actual = builder.build(args)
    actual.isSuccess shouldBe true
    val result = actual.get
    result shouldBe conf
  }

}
