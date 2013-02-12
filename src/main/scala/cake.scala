package cake

trait HasLogger extends cake.services.HasLogger {
  type LoggerType = Logger
  class Logger(logFileName: String) extends cake.logger.FileLogger(logFileName)
}

trait HasDatabase extends cake.services.HasDatabase {
  type DatabaseType = Database
  class Database(dsn: String, username: String, password: String) extends cake.database.DBI(dsn, username, password)
}

trait HasApplication extends cake.services.HasApplication {
  this: cake.HasLogger with cake.HasDatabase =>
  type ApplicationType = Application
  class Application extends cake.application.Application(logger, database)
}

object Container extends HasApplication with HasLogger with HasDatabase {
  val logger      = new Logger("out.log")
  // val database    = Database.connect("dbi:mysql:myapp", "doy", "blah")
  val database    = new Database("dbi:mysql:myapp", "doy", "blah")
  val application = new Application
}
