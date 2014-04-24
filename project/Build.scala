import sbt._
import Keys._

object BuildSettings {
  val Organization = "BalajiSivaraman"
  val Version = "0.1.0"
  val ScalaVersion = "2.11.0"

  val buildSettings = Defaults.defaultSettings ++ Seq (
    organization := Organization,
    version := Version,
    scalaVersion := ScalaVersion
  )
}

object Resolvers {
  val SonatypeSnapshots = "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
  val SonatypeReleases = "Sonatype OSS Releases" at "https://oss.sonatype.org/content/repositories/releases"
  val AllResolvers = Seq(SonatypeSnapshots, SonatypeSnapshots)
}

object Dependencies {
  val Parboiled2 = "org.parboiled" %% "parboiled" % "2.0.0-RC1"
  val ScalaReflect = "org.scala-lang" % "scala-reflect" % BuildSettings.ScalaVersion

  val Specs2 = "org.specs2" %% "specs2" % "2.3.11" % "test"

  val TestDeps = Seq(Specs2)
  val AllDeps = Seq(Parboiled2, ScalaReflect ) ++ TestDeps
}

object SprayAuthBuild extends Build {
  import BuildSettings._
  import Dependencies._
  import Resolvers._
  
  lazy val SprayAuthProject = Project(
    "tapl-scala",
    file ("."),
    settings = buildSettings ++ Seq(resolvers := AllResolvers, libraryDependencies := AllDeps)
  )
}
