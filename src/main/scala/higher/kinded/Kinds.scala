package higher.kinded

object Kinds {

  trait MyCollection[F[_]]


  case class ListCollection[A](list: List[A]) extends MyCollection[List]

  type leftStringEither[A] = Either[String,A]

  case class EitherCollection[A, B](list: List[A]) extends MyCollection[leftStringEither]




  trait Transform[A, B] {
    def transform(a: A): B
  }

  abstract case class StringTransForm[A, B]() extends Transform[A, B]

  type ->[A, B] = StringTransForm[A, B]


  new (String -> Int) {
    override def transform(a: String): Int = 0
  }


}
