package functional.scala.day2.part1

import java.io.File

object Exercise {

  //Exercise 3

  trait PathLike[A] {
    def child(parent: A, name: String): A

    def parent(node: A): Option[A]

    def root: A
  }

  object PathLike {
    def apply[A](implicit ev: PathLike[A]): PathLike[A] = ev

    implicit val pathLike = new PathLike[java.io.File] {
      override def child(parent: File, name: String): File = parent

      override def parent(node: File): Option[File] = Option(node.getParentFile)

      override def root: File = java.io.File.listRoots().head
    }
  }

}
