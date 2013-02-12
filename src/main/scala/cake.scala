package cake

trait HasLogger extends cake.services.HasLogger {
  type LoggerType = Logger
  class Logger(logFileName: String) extends cake.logger.FileLogger(logFileName) with ILogger
}

trait HasDatabase extends cake.services.HasDatabase {
  type DatabaseType = Database
  class Database(dsn: String, username: String, password: String) extends cake.database.DBI(dsn, username, password) with IDatabase
}

trait HasApplication extends cake.services.HasApplication {
  this: cake.HasLogger with cake.HasDatabase =>
  type ApplicationType = Application
  class Application extends cake.application.Application(logger, database) with IApplication
}

class Container (
  logFileName: String = "out.log",
  dsn:         String = "dbi:mysql:myapp",
  username:    String = "doy",
  password:    String = "blah"
  ) extends HasApplication with HasLogger with HasDatabase {
  val logger      = new Logger(logFileName)
  // val database    = Database.connect("dbi:mysql:myapp", "doy", "blah")
  val database    = new Database(dsn, username, password)
  val application = new Application
}

object MyApp extends Application {
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
