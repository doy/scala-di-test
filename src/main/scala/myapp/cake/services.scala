package myapp.cake.services

import myapp.database.Database
import myapp.logger.Logger

trait HasApplication {
  type ApplicationType

  val application: ApplicationType with ApplicationService

  trait ApplicationService {
    def run (): Unit
  }
}

trait HasDatabase {
  type DatabaseType

  val database: DatabaseType with DatabaseService

  trait DatabaseService extends Database
}

trait HasLogger {
  type LoggerType

  val logger: LoggerType with LoggerService

  trait LoggerService extends Logger
}
