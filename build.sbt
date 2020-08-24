name := "FunctionalScala"

version := "0.1"

scalaVersion := "2.13.0"

//scalacOptions += "-Ypartial-unification"

val ScalaZVersion     = "7.2.26"

// https://mvnrepository.com/artifact/org.scalatest/scalatest
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % Test
libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.2.29"



resolvers += Resolver.sonatypeRepo("releases")

addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.10.3")

// if your project uses multiple Scala versions, use this for cross building

// if your project uses both 2.10 and polymorphic lambdas
libraryDependencies ++= (scalaBinaryVersion.value match {
  case "2.10" =>
    compilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full) :: Nil
  case _ =>
    Nil
})

libraryDependencies += "org.typelevel" %% "cats-core" % "2.0.0"