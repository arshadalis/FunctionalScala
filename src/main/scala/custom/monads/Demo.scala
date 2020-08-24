package custom.monads

object Demo extends App {


  def increment: Int => Int = in => in + 1

  def add[A](value: A, func: A => A) = func(value)

  add(2, increment)


}
