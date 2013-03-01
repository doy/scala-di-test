package myapp.cake

object services {
  import database.Database
  import logger.Logger

  trait HasApplication {
    type ApplicationType

    def application: ApplicationType with ApplicationService

    trait ApplicationService {
      def run: Unit
    }
  }

  trait HasDatabase {
    type DatabaseType

    def database: DatabaseType with DatabaseService

    trait DatabaseService extends Database
  }

  trait HasLogger {
    type LoggerType

    def logger: LoggerType with LoggerService

    trait LoggerService extends Logger
  }
}
