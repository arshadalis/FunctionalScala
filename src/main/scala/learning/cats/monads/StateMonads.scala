package learning.cats.monads

import cats.data.State


object StateMonads {

  val counter = State[Int, String] {
    state => (state + 1, s"$state was added with 1")
  }

  val double = State[Int, String] {
    state => (state * 2, s"$state was multiplied by 2")
  }


  val both = for {
    a <- counter
    b <- double
  } yield (a, b)


}
