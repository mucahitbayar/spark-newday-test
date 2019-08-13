package com.newday.mucahit

import org.apache.spark.sql.functions._
import org.apache.spark.sql.{Column, DataFrame, SparkSession}

class DataReader {

  def read(spark: SparkSession, filePath: String, delimiter: String,columnNames: Seq[String]): DataFrame = {
    import spark.implicits._
    val arrayColumnName = "fields"
    val rawDF = spark.read.text(filePath)
    rawDF.select(split($"value", delimiter).as(arrayColumnName))
      .select(arrayToColumns(arrayColumnName, columnNames): _*)
  }

  def arrayToColumns(arrayColumnName: String, columnNames: Seq[String]): Seq[Column] = {
    columnNames.zipWithIndex.map(f => column(arrayColumnName).getItem(f._2).as(f._1))
  }
}


