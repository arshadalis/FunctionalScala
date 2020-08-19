package custom.monads

import scala.util.Random

object StateMonadExample extends App {

  type Seed = Long

  def rng(seed: Seed): (Seed, Long) = (seed * 2, Random.nextLong(seed))

  case class State[S, A](run: S => (S, A)) extends AnyVal {

    def map[B](f: A => B): State[S, B] = State(state => {
      val tuple = run(state)
      (tuple._1, f(tuple._2))
    })

    def flatMap[B](f: A => State[S, B]): State[S, B] = State(s => {
      val (s1, a) = run(s)
      f(a).run(s1)
    })
  }

  val nextLong: State[Seed, Long] = State(state => rng(state))

  val s: (Seed, String) = nextLong.map(l => l > 0).map(bool => if (bool) "positive" else "negative").run(3L)

  val program: State[Seed, Long] = for {
    s0 <- nextLong
    s1 <- nextLong
    s2 <- nextLong
  } yield s0 + s1 + s2

  program.run(1L)




}
