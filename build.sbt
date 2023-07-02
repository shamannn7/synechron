name := "WordCounter"

version := "0.1"

scalaVersion := "2.12.4"

libraryDependencies ++= {
  val akkaHttpV      = "10.2.10"
  val akkaV          = "2.6.20"
  val scalaTestV     = "3.2.15"

  Seq(
    "org.scalatest"     %% "scalatest" % scalaTestV % "test"
  ) ++ Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaV,
    "com.typesafe.akka" %% "akka-stream" % akkaV,
    "com.typesafe.akka" %% "akka-http" % akkaHttpV,
    "com.typesafe.akka" %% "akka-testkit" % akkaV
  )
}