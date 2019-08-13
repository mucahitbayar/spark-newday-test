package com.newday.mucahit

case class AppConfig(moviesFilePath: Option[String] = None, ratingsFilePath: Option[String] = None)

object AppConfig {
  def apply(moviesFilePath: String, ratingsFilePath: String): AppConfig =
    new AppConfig(Option(moviesFilePath), Option(ratingsFilePath))
}
