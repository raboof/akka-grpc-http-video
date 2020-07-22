enablePlugins(AkkaGrpcPlugin)

fork := true

enablePlugins(ParadoxRevealPlugin)

resolvers += Resolver.bintrayRepo("akka", "snapshots")
val akkaHttpVersion = "10.2.0-RC1+68-f23a027a"

scalaVersion := "2.13.2"

scalacOptions ++= Seq(
  "-Xfatal-warnings",
  "-deprecation",
)

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http2-support" % akkaHttpVersion
)
