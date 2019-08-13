package com.newday.mucahit

case class AppConfig(moviesFilePath:String,ratingsFilePath:String){
  require(Option(moviesFilePath).exists(s=>s.trim.nonEmpty),"movies file path can not be empty")
  require(Option(ratingsFilePath).exists(s=>s.trim.nonEmpty),"ratings file path can not be empty")
}
