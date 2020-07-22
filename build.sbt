enablePlugins(AkkaGrpcPlugin)

fork := true

enablePlugins(ParadoxRevealPlugin)

val akkaHttpVersion = "10.2.0-RC1"

scalaVersion := "2.13.2"

scalacOptions += "-Xfatal-warnings"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http2-support" % akkaHttpVersion
)
