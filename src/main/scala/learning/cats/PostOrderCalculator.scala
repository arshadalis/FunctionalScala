package learning.cats

import cats.data.State

object PostOrderCalculator {

  type CalcState[A] = State[List[String], A]

  def operand(toInt: Int) = State[List[Int], Int](state => {
    (toInt +: state, toInt)
  }
  )

  def evalOne(sym: String) = sym match {
    case "*" => operator(_ * _)
    case "+" => operator(_ + _)
    case s => operand(s.toInt)
  }

  private def operator(f: (Int, Int) => Int) = State[List[Int], Int] {
    case head :: sec :: tail => (f(head, sec) +: tail, f(head, sec))
  }

  def calculate(string: String) = {
    string.split(" ").toList.foldLeft(State.pure[List[Int], Int](0))((a, string) => {
      a.flatMap(_ => evalOne(string))
    })
  }




}
