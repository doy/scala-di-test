package logger

trait Logger {
  def log (msg: String): Unit
}

class FileLogger (logFileName: String) extends Logger {
  def log (msg: String) {
    println("writing " + msg + " to " + logFileName)
  }
}
