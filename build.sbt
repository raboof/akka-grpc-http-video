enablePlugins(AkkaGrpcPlugin)

fork := true

enablePlugins(ParadoxRevealPlugin)

val akkaHttpVersion = "10.2.0-RC2"

scalaVersion := "2.13.2"

scalacOptions ++= Seq(
  "-Xfatal-warnings",
  "-deprecation",
)

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http2-support" % akkaHttpVersion
)
