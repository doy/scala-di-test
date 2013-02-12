package cake

trait HasLogger extends cake.services.HasLogger {
  type LoggerType = Logger
  class Logger(logFileName: String) extends cake.logger.FileLogger(logFileName) with ILogger
}

trait HasDatabase extends cake.services.HasDatabase {
  type DatabaseType = Database
  class Database protected (dsn: String, username: String, password: String) extends cake.database.DBI(dsn, username, password) with IDatabase
  object Database {
    def connect(dsn: String, username: String, password: String) =
      new Database(dsn, username, password)
  }
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
  lazy val application = new Application
  lazy val logger      = new Logger(logFileName)
  lazy val database    = Database.connect(dsn, username, password)
}
