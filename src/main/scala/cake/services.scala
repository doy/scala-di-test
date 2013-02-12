package cake.services

trait HasApplication {
  type ApplicationType
  val application: ApplicationType
}

trait HasDatabase {
  type DatabaseType
  val database: DatabaseType
}

trait HasLogger {
  type LoggerType
  val logger: LoggerType
}
