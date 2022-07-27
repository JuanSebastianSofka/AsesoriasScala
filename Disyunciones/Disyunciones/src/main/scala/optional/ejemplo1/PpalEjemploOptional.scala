package optional.ejemplo1

object PpalEjemploOptional {
  def main(args: Array[String]): Unit = {
    ejemplo1()
  }

  def ejemplo1(): Unit = {
    val lista = List.range(1, 6)

    //find devuelve un optional
    val resultado = lista.find(_ == 4)
    val resultado2 = lista.find(_ == 9)

    println(resultado) //devuelve Some(4)
    println(resultado2) //devuelve None

    //para manejar lo anterior. Se así para el manejo de algo None, porque si uso get directamente revienta
    val resultado3 = resultado
      .map(_.toString)
      .getOrElse("No se encontró el dato")

    val resultado4 = resultado2
      .map(_.toString)
      .getOrElse("No se encontró el dato")

    println(resultado3)
    println(resultado4)
  }
}
