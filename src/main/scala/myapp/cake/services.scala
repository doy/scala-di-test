package myapp.cake.services

import myapp.database.Database
import myapp.logger.Logger

trait HasApplication {
  type ApplicationType

  def application (): ApplicationType with ApplicationService

  trait ApplicationService {
    def run (): Unit
  }
}

trait HasDatabase {
  type DatabaseType

  def database (): DatabaseType with DatabaseService

  trait DatabaseService extends Database
}

trait HasLogger {
  type LoggerType

  def logger (): LoggerType with LoggerService

  trait LoggerService extends Logger
}
