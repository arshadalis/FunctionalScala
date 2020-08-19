package learning.cats.monads

import cats.data.Writer
import cats.syntax.vector._

object WiterMonads {

  def slowly[A](body: => A) =
    try body finally Thread.sleep(100)

  def factorial(n: Int): Int = {
    val ans = slowly(if (n == 0) 1 else n * factorial(n - 1))
    println(s"fact $n $ans")
    ans
  }


  def factorialWithWriter(n: Int, writer: Writer[Vector[String], Int], actorName: String): Writer[Vector[String], Int] = {
    val ans = slowly(if (n == 0) 1 else n * factorial(n - 1))
    writer.bimap(
      logs => logs.+:(s"fact $n $ans calculated by $actorName"),
      _ => ans
    )
  }

}
