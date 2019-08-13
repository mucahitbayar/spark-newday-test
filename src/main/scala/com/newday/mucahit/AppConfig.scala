package com.newday.mucahit

case class AppConfig(moviesFilePath: Option[String] = None, ratingsFilePath: Option[String] = None) {
  lazy val isValid: Boolean = moviesFilePath.exists(_.trim.nonEmpty) && ratingsFilePath.exists(_.trim.nonEmpty)
}

object AppConfig {
  def apply(moviesFilePath: String, ratingsFilePath: String): AppConfig =
    new AppConfig(Option(moviesFilePath), Option(ratingsFilePath))
}
