package learning.cats.functors

object ContravariantFunctors {

  trait Printable[A] {
    self =>

    def format(value: A): String

    def contramap[B](func: B => A): Printable[B] =
      new Printable[B] {
        def format(value: B): String = self.format(func(value))
      }
  }


  final case class Box[A](value: A)

  object Printable {
    def format[A](value: A)(implicit p: Printable[A]): String =
      p.format(value)

    def contramap[B, A](value: B)(func: B => A)(implicit ev: Printable[A]): String = format(func(value))

    implicit val stringPrintable: Printable[String] =
      new Printable[String] {
        def format(value: String): String =
          "\"" + value + "\""
      }

    implicit val booleanPrintable: Printable[Boolean] =
      new Printable[Boolean] {
        def format(value: Boolean): String =
          if (value) "yes" else "no"
      }
  }

}
