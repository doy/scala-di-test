package cake.services

trait HasApplication {
  type ApplicationType
  val application: ApplicationType with IApplication
  trait IApplication {
    def run (): Unit
  }
}

trait HasDatabase {
  type DatabaseType
  val database: DatabaseType with IDatabase
  trait IDatabase extends cake.database.Database
}

trait HasLogger {
  type LoggerType
  val logger: LoggerType with ILogger
  trait ILogger extends cake.logger.Logger
}
