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
  trait IDatabase {
    def query (search: String): String
  }
}

trait HasLogger {
  type LoggerType
  val logger: LoggerType with ILogger
  trait ILogger {
    def log (msg: String): Unit
  }
}
