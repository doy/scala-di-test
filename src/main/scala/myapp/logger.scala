package myapp.logger

trait Logger {
  def log (msg: String): Unit
}

class FileLogger (logFileName: String) extends Logger {
  def log (msg: String): Unit =
    println("writing " + msg + " to " + logFileName)
}
