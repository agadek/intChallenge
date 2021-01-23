name := "intChallenge"

version := "0.1"

scalaVersion := "2.13.4"

resolvers += "Artima Maven Repository" at "https://repo.artima.com/releases"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.2"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.2" % "test"
libraryDependencies += "org.scalatestplus" %% "scalacheck-1-15" % "3.2.2.0" % "test"
libraryDependencies += "org.typelevel" %% "cats-effect" % "2.3.1"