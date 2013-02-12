package cake.database

trait Database {
  def query (search: String): String
}

class DBI protected (
  val dsn:      String,
  val username: String,
  val password: String) extends Database {
  def query (search: String): String = "found " + search
  override def toString = List(dsn, username, password).mkString(", ")
}

object DBI {
  def connect (dsn: String, username: String, password: String) =
    new DBI(dsn, username, password)
}
