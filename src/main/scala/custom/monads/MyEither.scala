package custum.monads

trait MyEither[A, B] {
  def map[C](f: B => C): MyEither[A, C]

  def flatMap[C](f: B => MyEither[A, C]): MyEither[A, C]
}

case class MLeft[A, B](left: A) extends MyEither[A, B] {
  override def map[C](f: B => C): MyEither[A, C] = MLeft(left)

  override def flatMap[C](f: B => MyEither[A, C]): MyEither[A, C] = MLeft(left)
}

case class MRight[A, B](right: B) extends MyEither[A, B] {
  override def map[C](f: B => C): MyEither[A, C] = MRight(f(right))

  override def flatMap[C](f: B => MyEither[A, C]): MyEither[A, C] = f(right)
}




