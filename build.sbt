
javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint")


lazy val root = (project in file(".")).
  settings(
    name := "scala-lambda",
    version := "1.0",
    scalaVersion := "2.12.0",
    retrieveManaged := true,
    libraryDependencies += "com.amazonaws" % "aws-lambda-java-core" % "1.0.0",
    libraryDependencies += "com.amazonaws" % "aws-lambda-java-events" % "1.0.0"
  )

assemblyMergeStrategy in assembly := {
    case PathList("META-INF", xs @ _*) => MergeStrategy.discard
    case x => MergeStrategy.first
   }
