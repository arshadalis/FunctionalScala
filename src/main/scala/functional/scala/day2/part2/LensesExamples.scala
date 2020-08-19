package functional.scala.day2.part2

object LensesExamples extends App {

  case class Lens[State, Element]
  (
    get: State => Element,
    set: Element => State => State
  )

  case class Street(no: Int, name: String)

  case class Address(street: Street, pin: Int)

  case class Employee(id: Int, name: String, address: Address)

  case class Organisation(employees: Employee)

  val streetLense = Lens[Street, Int](
    street => street.no,
    number => street => street.copy(no = number)
  )

  val adressLens = Lens[Address, Street](
    add => add.street,
    street => address => address.copy(street = street)
  )

  def compose[Outer, Inner, Value](
                                    lensOuter: Lens[Outer, Inner],
                                    lensInner: Lens[Inner, Value]
                                  ) = Lens[Outer, Value](
    outer => lensInner.get(lensOuter.get(outer)),
    value => outer => lensOuter.set(lensInner.set(value)(lensOuter.get(outer)))(outer)
  )

  val l: Lens[Address, Int] = compose(adressLens, streetLense)


}
