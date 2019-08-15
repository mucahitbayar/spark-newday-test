package com.newday.mucahit

import org.apache.spark.sql.SparkSession

trait SparkRunner {
  def run(spark:SparkSession):Unit
}


