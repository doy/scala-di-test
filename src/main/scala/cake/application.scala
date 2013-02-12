package cake.application

import cake.logger.FileLogger
import cake.database.DBI

class Application (val logger: FileLogger, val dbh: DBI) {
  def run (): Unit = {
    logger.log("starting")
    logger.log("got a dbh: " +
      List(dbh.dsn, dbh.username, dbh.password).mkString(", "))
    logger.log("ending")
  }
}
