package traitOtroEjemplo
//esto es lo que mas encontraremos en proyectos Scala
//esta es otra forma de usar el typeAlias

trait Repeat {
  type RepeatType //estoy oligando a quien use el trait, le de un tipo a este type

  def apply(item: RepeatType, reps: Int): RepeatType
}

object IntegerRepeat extends Repeat {
  override type RepeatType = Int

  override def apply(item: RepeatType, reps: Int): RepeatType = (item.toString * reps).toInt
}

object StringRepeat extends Repeat {
  override type RepeatType = String

  override def apply(item: RepeatType, reps: Int): RepeatType = (item * reps)
}

object RepeatTest{
  def main(args: Array[String]): Unit = {
    println(IntegerRepeat.apply(5,6)) //imprime el numero 5, 6 veces
    println(StringRepeat("Hola ",3))
  }
}