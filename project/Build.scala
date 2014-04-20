import sbt._
import Keys._

object BuildSettings {
  val buildOrganization = "BalajiSivaraman"
  val buildVersion = "0.1.0"
  val buildScalaVersion = "2.10.4"

  val buildSettings = Defaults.defaultSettings ++ Seq (
    organization := buildOrganization,
    version := buildVersion,
    scalaVersion := buildScalaVersion
  )
}

object Dependencies {
  val parboiled2 = "org.parboiled" %% "parboiled" % "2.0-M2"
  val allDeps = Seq(parboiled2)
}

object SprayAuthBuild extends Build {
  import BuildSettings._
  import Dependencies._
  
  lazy val SprayAuthProject = Project(
    "tapl-scala",
    file ("."),
    settings = buildSettings ++ Seq(libraryDependencies := allDeps)
  )
}
