package cake.database

class DBI protected (
  val dsn:      String,
  val username: String,
  val password: String) {
  def query (search: String): String = "found " + search
  override def toString = List(dsn, username, password).mkString(", ")
}

object DBI {
  def connect (dsn: String, username: String, password: String) =
    new DBI(dsn, username, password)
}
