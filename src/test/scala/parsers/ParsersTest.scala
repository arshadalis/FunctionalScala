package parsers

import org.scalatest.{FunSpec, Matchers}

class ParsersTest extends FunSpec with Matchers {


  describe("Parser Test") {
    type Error = String

    val firstUpperChar: String => Either[Error, (String, Char)] = string => {
      if (string.isEmpty) Left("Empty String provided")
      else Right((string.drop(1), string.charAt(0).toUpper))
    }

    it("should return output with Either of result or failure") {
      firstUpperChar("arshad") shouldEqual Right("rshad", 'A')
      firstUpperChar("ar") shouldEqual Right("r", 'A')
      firstUpperChar("a") shouldEqual Right("", 'A')
      //negative
      firstUpperChar("") shouldEqual Left("Empty String provided")
    }
  }

}
