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
          opt[Option[String]](AppConfigBuilder.Fields.moviesInputPath.short, AppConfigBuilder.Fields.moviesInputPath.full)
            .action((x, c) => c.copy(moviesInputPath = x))
            .text("moviesInputPath is a input file path property"),
          opt[Option[String]](AppConfigBuilder.Fields.moviesOutputPath.short, AppConfigBuilder.Fields.moviesOutputPath.full)
            .action((x, c) => c.copy(moviesOutputPath = x))
            .text("moviesOutputPath is a output file path property"),
          opt[Option[String]](AppConfigBuilder.Fields.ratingsInputPath.short, AppConfigBuilder.Fields.ratingsInputPath.full)
            .action((x, c) => c.copy(ratingsInputPath = x))
            .text("ratingsInputPath is a input file path property"),
          opt[Option[String]](AppConfigBuilder.Fields.ratingsOutputPath.short, AppConfigBuilder.Fields.ratingsOutputPath.full)
            .action((x, c) => c.copy(ratingsOutputPath = x))
            .text("ratingsOutputPath is a output file path property"),
          opt[String](AppConfigBuilder.Fields.delimiter.short, AppConfigBuilder.Fields.delimiter.full)
            .action((x, c) => c.copy(delimiter = x))
            .text("delimiter")
        )
      }
      OParser.parse(parser1, args, AppConfig()).get
    }
  }
}

object AppConfigBuilder {
  case class Parameter(short:Char,full:String)
  object Fields{
    val moviesInputPath:Parameter=Parameter('i',"moviesInputPath")
    val moviesOutputPath:Parameter=Parameter('m',"moviesOutputPath")
    val ratingsInputPath:Parameter=Parameter('r',"ratingsInputPath")
    val ratingsOutputPath:Parameter=Parameter('s',"ratingsOutputPath")
    val delimiter:Parameter=Parameter('d',"delimiter")
  }
  def apply(): AppConfigBuilder = new AppConfigBuilder()
}
