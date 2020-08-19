package pfp

object TaglessWay extends App {

  println("=" * 150)

  case class Item(id: Int) extends AnyVal

  trait CounterAlg[F[_]] {
    def incr: F[Unit]

    def get: F[Int]
  }



}
