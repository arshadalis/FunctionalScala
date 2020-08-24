package learning.cats.monads

import cats.data.{Writer, WriterT}
import learning.cats.monads.WiterMonads.{factorial, factorialWithWriter}
import org.scalatest.{FunSpec, Matchers}

import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

class WiterMonadsTest extends FunSpec with Matchers {

  describe("Writer Monads") {
    /*it("should log the output interleaved without the use of writer") {
      Await.result(Future.sequence(Vector(
        Future(factorial(5)),
        Future(factorial(5))
      )), 5.seconds)
    }*/


    it("should log the output for actor with the use of writer") {
      val writer = Writer(Vector[String](), 0)

      Await.result(Future.sequence(Vector(
        Future(factorialWithWriter(7, writer, "First").run),
        Future(factorialWithWriter(5, writer, "First").run)
      )), 5.seconds)
    }

  }

}
