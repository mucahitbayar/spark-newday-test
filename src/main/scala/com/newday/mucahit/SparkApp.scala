package com.newday.mucahit

import org.apache.spark.sql.SparkSession

import scala.util.{Failure, Success}

object SparkApp {
  def main(args: Array[String]): Unit = {
    AppConfigBuilder().build(args) match {
      case Success(conf) if conf.isValid =>
        val spark = SparkSession
          .builder()
          .appName("NewDay Interview")
          .master("local[*]")
          .getOrCreate()

        val runner = NewDaySparkRunner(conf)
        runner.run(spark)

      case Failure(exception) =>
        throw new Exception(exception)
    }
  }


}
