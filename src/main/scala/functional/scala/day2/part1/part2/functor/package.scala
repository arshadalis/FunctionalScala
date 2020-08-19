package functional.scala.day2.part1.part2

import scala.language.higherKinds

package object functor {

  type ~>[F[_], G[_]] = NaturalTransformation[F, G]

}
