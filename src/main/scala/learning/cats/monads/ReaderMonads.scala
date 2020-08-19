package learning.cats.monads

import cats.data.Reader


object ReaderMonads {

  case class Db(
                 usernames: Map[Int, String],
                 passwords: Map[String, String]
               )

  type DbReader[A] = Reader[Db, A]

  def findUsername(userId: Int): DbReader[Option[String]] =
    Reader(db => db.usernames.get(userId))

  def checkPassword(
                     username: String,
                     password: String): DbReader[Boolean] =
    Reader(db => db.passwords.get(username).contains(password))

  def checkLogin(
                  userId: Int,
                  password: String): DbReader[Boolean] =
    Reader(db => db.usernames.get(userId)
      .exists(userName =>
        db.passwords.get(userName).contains(password)
      )
    )


}
