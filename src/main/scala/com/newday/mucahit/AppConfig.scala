package com.newday.mucahit

case class AppConfig(moviesInputPath: Option[String] = None,
                     moviesOutputPath: Option[String] = None,
                     ratingsInputPath: Option[String] = None,
                     ratingsOutputPath: Option[String] = None,
                     delimiter: String = ",") {
  lazy val isValid: Boolean =
    moviesInputPath.exists(_.trim.nonEmpty) &&
      moviesOutputPath.exists(_.trim.nonEmpty) &&
      ratingsInputPath.exists(_.trim.nonEmpty) &&
      ratingsOutputPath.exists(_.trim.nonEmpty) &&
      Option(delimiter).exists(_.trim.nonEmpty)
}

object AppConfig {
  def apply(moviesFilePath: String,
            moviesOutputPath: String,
            ratingsFilePath: String,
            ratingsOutputPath: String,
            delimiter: String): AppConfig = {
    new AppConfig(Option(moviesFilePath),
      Option(moviesOutputPath),
      Option(ratingsFilePath),
      Option(ratingsOutputPath),
      delimiter)
  }
}
