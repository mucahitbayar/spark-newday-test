package com.newday.mucahit

import scala.util.Try

trait ConfigBuilder[T] {
  def build(args: Array[String]): Try[T]
}


