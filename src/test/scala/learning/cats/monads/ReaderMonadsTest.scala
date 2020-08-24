package learning.cats.monads

import learning.cats.monads.ReaderMonads.{Db, checkLogin}
import org.scalatest.{FunSpec, Matchers}


class ReaderMonadsTest extends FunSpec with Matchers {

  val users: Map[Int, String] = Map(1 -> "dade", 2 -> "kate", 3 -> "margo")
  val passwords: Map[String, String] = Map("dade" -> "zerocool", "kate" -> "acidburn", "margo" -> "secret")

  val db = Db(users, passwords)

  describe("ReaderMonad Test") {
    it("should login with valid user id and password") {
      checkLogin(1, "zerocool").run(db) shouldEqual true
    }

    it("should not login with invalid user id") {
      checkLogin(4, "davinci").run(db) shouldEqual false
    }

    it("should not login with valid user id but invalid password") {
      checkLogin(2, "davinci").run(db) shouldEqual false
    }


  }

}
