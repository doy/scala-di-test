package database

trait Database {
  def query (search: String): String
}

class DBI protected (
  dsn:      String,
  username: String,
  password: String
) extends Database {
  def query (search: String): String =
    "found " + search

  override def toString: String =
    List(dsn, username, password).mkString(", ")
}

object DBI {
  def connect (dsn: String, username: String, password: String): DBI =
    new DBI(dsn, username, password)
}
