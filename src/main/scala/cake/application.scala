package cake.application

import cake.logger.Logger
import cake.database.Database

class Application (val logger: Logger, val dbh: Database) {
  def run (): Unit = {
    logger.log("starting")
    logger.log("got a dbh: " + dbh)
    logger.log(dbh.query("foo"))
    logger.log("ending")
  }
}
