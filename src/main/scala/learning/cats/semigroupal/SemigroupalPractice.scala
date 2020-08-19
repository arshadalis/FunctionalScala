import cats.Semigroupal
import cats.instances.option._


object SemigroupalPractice extends App {

  println(Semigroupal[Option].product(Some(12), Some(12)))


}
