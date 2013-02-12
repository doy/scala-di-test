package cake.application

import cake.logger.Logger
import cake.database.Database

class Application (logger: Logger, dbh: Database) {
  def run (): Unit = {
    logger.log("starting")
    logger.log("got a dbh: " + dbh)
    logger.log(dbh.query("foo"))
    logger.log("ending")
  }
}
