package com.newday.mucahit

import scopt.OParser
import scala.util.Try

class AppConfigBuilder extends ConfigBuilder[AppConfig] {
  def build(args: Array[String]): Try[AppConfig] = {
    Try {
      val builder = OParser.builder[AppConfig]
      val parser1 = {
        import builder._
        OParser.sequence(
          programName("scopt"),
          head("scopt", "4.x"),
          opt[Option[String]](AppConfigBuilder.Fields.moviesFilePath.short, AppConfigBuilder.Fields.moviesFilePath.full)
            .action((x, c) => c.copy(moviesFilePath = x))
            .text("moviesFilePath is a file path property"),
          opt[Option[String]](AppConfigBuilder.Fields.ratingsFilePath.short, AppConfigBuilder.Fields.ratingsFilePath.full)
            .action((x, c) => c.copy(ratingsFilePath = x))
            .text("ratingsFilePath is a file path property")
        )
      }
      OParser.parse(parser1, args, AppConfig()).get
    }
  }
}

object AppConfigBuilder {
  case class Parameter(short:Char,full:String)
  object Fields{
    val moviesFilePath:Parameter=Parameter('m',"moviesFilePath")
    val ratingsFilePath:Parameter=Parameter('r',"ratingsFilePath")
  }
  def apply(): AppConfigBuilder = new AppConfigBuilder()
}
