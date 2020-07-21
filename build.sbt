enablePlugins(AkkaGrpcPlugin)

fork := true

enablePlugins(ParadoxRevealPlugin)

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http" % "10.2.0-RC1",
  "com.typesafe.akka" %% "akka-http2-support" % "10.2.0-RC1",
)
