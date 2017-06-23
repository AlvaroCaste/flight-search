name := "flight-search"

version := "1.0"

scalaVersion := "2.11.11"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

libraryDependencies ++= Seq(
  "net.codingwell" %% "scala-guice" % "4.1.0",
  "com.nrinaudo" %% "kantan.csv" % "0.1.19",
  "com.nrinaudo" %% "kantan.csv-generic" % "0.1.19",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test"
)

routesGenerator := InjectedRoutesGenerator
