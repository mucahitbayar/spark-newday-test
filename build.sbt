name := "spark-newday-test"

version := "0.1"

scalaVersion := "2.12.0"

val sparkVersion = "2.4.3"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  "com.typesafe" % "config" % "1.3.4",
  "com.github.scopt" %% "scopt" % "4.0.0-RC2",
  "org.scalatest" %% "scalatest" % "3.2.0-SNAP10" % Test,
  "com.holdenkarau" %% "spark-testing-base" % s"${sparkVersion}_0.12.0" % Test
)
