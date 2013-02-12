package cake.application

import cake.services._

class Application (val logger: HasLogger#ILogger, val dbh: HasDatabase#IDatabase) {
  def run (): Unit = {
    logger.log("starting")
    logger.log("got a dbh: " + dbh)
    logger.log(dbh.query("foo"))
    logger.log("ending")
  }
}
