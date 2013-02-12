package cake.logger

trait Logger {
  def log (msg: String): Unit
}

class FileLogger (val logFileName: String) extends Logger {
  def log (msg: String): Unit =
    println("writing " + msg + " to " + logFileName)
}
