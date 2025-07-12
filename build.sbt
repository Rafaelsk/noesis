ThisBuild / scalaVersion := "3.3.6"

lazy val noesis = (project in file("."))
  .settings(
    name := "noesis",
    version := "0.1.0",
    organization := "org.noesis",
    description := "A logical inference engine for structured beliefs and axioms.",
    libraryDependencies ++= Seq(
      "com.lihaoyi" %% "fastparse" % "3.1.1",
      "com.lihaoyi" %% "upickle" % "4.2.1",
      "org.scalatest" %% "scalatest" % "3.2.19" % Test
    )
  )
