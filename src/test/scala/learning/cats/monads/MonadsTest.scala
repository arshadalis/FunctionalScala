package learning.cats.monads

import learning.cats.monads.Monads.{Monad, Person, Tabut}
import org.scalatest.{FunSpec, Matchers}


class MonadsTest extends FunSpec with Matchers {
  val person = Person(1, "pune")

  describe("MonadTest") {
    it("should create tabut of Person using pure") {
      val tabutOfPerson = Monad[Tabut].pure(person)
      tabutOfPerson.isInstanceOf[Tabut[Person]] shouldEqual true

    }

    it("should map tabut of person") {
      val tabutOfPerson = Monad[Tabut].pure(person)

      val newTabut = Monad[Tabut].map(tabutOfPerson)(person => person.copy(id = 20))

      newTabut shouldEqual Tabut(Person(20, "pune"))
    }

    it("should flatMap tabut of person") {
      val tabutOfPerson = Monad[Tabut].pure(person)

      val newTabut = Monad[Tabut].flatMap(tabutOfPerson)(person => Tabut(person.copy(id = 20)))

      newTabut shouldEqual Tabut(Person(20, "pune"))
    }
  }

}
