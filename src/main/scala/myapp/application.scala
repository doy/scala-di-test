package myapp.application

import myapp.logger.Logger
import myapp.database.Database

class MyApp (logger: Logger, dbh: Database) {
  def run {
    logger.log("starting")
    logger.log("got a dbh: " + dbh)
    logger.log(dbh.query("foo"))
    logger.log("ending")
  }
}
