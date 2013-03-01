package myapp

import myapp.cake.Container

object Runner extends App {
  val container1 = new Container
  println("running container 1")
  container1.application.run
  println("done with container 1")

  val container2 = new Container(logFileName = "other.log")
  println("running container 2")
  container2.application.run
  println("done with container 2")

  val container3 = new Container(
    dsn      = "dbi:SQLite::memory:",
    username = "",
    password = ""
  )
  println("running container 3")
  container3.application.run
  println("done with container 3")
}
