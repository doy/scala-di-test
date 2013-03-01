package myapp.cake

import database.DBI
import logger.FileLogger

import myapp.MyApp

class Container (
  logFileName: String = "out.log",
  dsn:         String = "dbi:mysql:myapp",
  username:    String = "doy",
  password:    String = "blah"
) extends HasApplication with HasLogger with HasDatabase {
  def application = new Application
  // def logger   = new Logger(logFileName) // non-singleton
  lazy val logger = new Logger(logFileName) // singleton
  def database    = Database.connect(dsn, username, password)
}

trait HasLogger extends services.HasLogger {
  type LoggerType = Logger

  class Logger (
    logFileName: String
  ) extends FileLogger(logFileName) with LoggerService
}

trait HasDatabase extends services.HasDatabase {
  type DatabaseType = Database

  class Database protected (
    dsn:      String,
    username: String,
    password: String
  ) extends DBI(dsn, username, password) with DatabaseService

  object Database {
    def connect(dsn: String, username: String, password: String) =
      new Database(dsn, username, password)
  }
}

trait HasApplication extends services.HasApplication {
  this: HasLogger with HasDatabase =>

  type ApplicationType = Application

  class Application extends MyApp(logger, database) with ApplicationService
}
