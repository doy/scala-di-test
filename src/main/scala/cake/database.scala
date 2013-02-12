package cake.database

// class DBI private (
class DBI (
  val dsn:      String,
  val username: String,
  val password: String) {
  def query (search: String): String = "found " + search
}

// object DBI {
//   def connect (dsn: String, username: String, password: String) =
//     new DBI(dsn, username, password)
// }
