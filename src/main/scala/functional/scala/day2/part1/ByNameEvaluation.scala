package functional.scala.day2.part1

object ByNameEvaluation {

  object test {
    def testMe(string: String, r: => String): String = string + r
  }

  test.testMe("wwwww",{
  var a = "abc"
  s"$a     jjjj"
  })

}
