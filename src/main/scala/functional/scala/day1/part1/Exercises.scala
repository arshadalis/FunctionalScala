package functional.scala.day1.part1

object Exercises {

  //
  // EXERCISE 10
  //
  // Prove that `A * 1` is equivalent to `A` by implementing the following two
  // functions.
  //

  def to1[A](t: (A, Unit)): A = t._1


  def from1[A](a: A): (A, Unit) = (a, ())


  //
  // EXERCISE 11
  //
  // Prove that `A * 0` is equivalent to `0` by implementing the following two
  // functions.
  //
  def to2[A](t: (A, Nothing)): Nothing = t._2

  def from2[A](n: Nothing): (A, Nothing) = n

  // Nothing is subtype of all types
  // hence we are able to return n where it hass
  // dont have any value of type nothing hence cant call this function

  //
  // EXERCISE 12
  //
  // Create a sum type of `Int` and `String` representing the identifier of
  // a robot (a number) or the identifier of a person (a name).
  //
  type Identifier1 = Either[Int, String]

  sealed trait Identifier2

  case class Robot(number: Int) extends Identifier2

  case class Person(name: String) extends Identifier2


  //
  // EXERCISE 13
  //
  // Prove that `A + 0` is equivalent to `A` by implementing the following two
  // functions.
  //
  def to3[A](t: Either[A, Nothing]): A = t.left.get

  def from3[A](a: A): Either[A, Nothing] = Left(a)


  // trying private case class constructor
  case class PersonNew private(age: Int)

  object PersonNew {
    def apply(age: Int): PersonNew = new PersonNew(age)
  }


  ////////////////////////////////higher_order  functions


  //
  // EXERCISE 1
  //
  // Implement the following higher-order function.
  //
  def fanout[A, B, C](f: A => B, g: A => C): A => (B, C) = a => (f(a), g(a))


  //
  // EXERCISE 3
  // Implement the following higher-order function.
  //
  def either[A, B, C](f: A => B, g: C => B): Either[A, C] => B = either => either.fold[B](a => f(a), c => g(c))


  //
  // EXERCISE 4
  //
  // Implement the following higher-order function.
  //
  def choice[A, B, C, D](f: A => B, g: C => D): Either[A, C] => Either[B, D] = either => either.fold(a => Left(f(a)), c => Right(g(c)))


  //
  // EXERCISE 5
  //
  // Implement the following higher-order function.
  //
  def compose[A, B, C](f: B => C, g: A => B): A => C = a => f(g(a))

  //
  // EXERCISE 6
  //
  // Implement the following higher-order function. After you implement
  // the function, interpret its meaning.
  //

  def alt[E1, E2, A, B](l: Parser[E1, A], r: E1 => Parser[E2, B]):
  Parser[(E1, E2), Either[A, B]] = Parser(string => {
    l.parserFun(string) match {
      case Right((remStr, res)) => Right(remStr, Left(res))
      case Left(e1) => r(e1).parserFun(string) match {
        case Left(e2) => Left(e1, e2)
        case Right((remStr, b)) => Right(remStr, Right(b))
      }
    }
  })

  case class Parser[E, A](parserFun: String => Either[E, (String, A)])


  object Parser {
    final def fail[E](e: E): Parser[E, Nothing] =
      Parser(_ => Left(e))

    final def succeed[A](a: => A): Parser[Nothing, A] =
      Parser(input => Right((input, a)))

    final def char: Parser[Unit, Char] =
      Parser(input =>
        if (input.length == 0) Left(())
        else Right((input.drop(1), input.charAt(0))))
  }

  //  def kinded[A: Int, B](a: A, b: B): B = b

  trait Vehicle

  case object Car extends Vehicle

  case object Bike extends Vehicle


  //partial application

  trait Sized[F[_]] {
    def size[A](a: F[A]): Int
  }

  def MapSize[K]: Sized[Map[K, ?]] =
    new Sized[Map[K, ?]] {
      override def size[A](a: Map[K, A]): Int = a.size
    }

}