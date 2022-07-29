object PpalColeccionesEjemplo {

  def main(args: Array[String]): Unit = {
    ejemploListas()
    ejemploConClase()
    ejemploOpcionales()
  }

  //listas
  def ejemploListas(): Unit = {
    val lista = List(1, 2, 3, 4, 5, 6)
    lista.foreach(x => println(x))
  }

  def ejemploTipadoLista(): Unit = {
    val lista: List[Int] = List(1, 2, 3, 4, 5, 6)
    lista.foreach(x => println(x))
  }

  def ejemploOperandoListas(): Unit = {
    val lista: List[Int] = List(1, 2, 3, 4, 5, 6)
    println(lista.last)
    println(lista.head)
    println(lista.isEmpty)
    println(lista.length)
  }

  def ejemploConNil(): Unit = {
    //nil representa que la lista es vacia
    val lista: List[Int] = Nil //es lo mismo que List()
  }

  def ejemploConcatenando(): Unit = {
    val lista = List.range(1, 8)
    val lista2 = List.range(9, 16)

    println(s"lista = ${lista :: lista2}")
    println(s"lista = ${lista ::: lista2}")
  }

  def ejemploOpcionales(): Unit = {
    val lista = List(Option(1), Option(2), Option(2), None)
    println(lista.flatten.sum)
  }

  def ejemploReglasNegocio(): Unit = {
    val lista = List((1, "felipe"), (2, "Juan"), (1, "Mario"))
    println(lista.groupBy(_._1)) //para la clave 1 guarda a mario y felipe
  }

  def ejemploInvertir(): Unit = {
    val lista = List((1, "felipe"), (2, "Juan"), (1, "Mario"))
    println(lista.reverse)
  }

  def ejemploConClase(): Unit = {
    val item = List(Item(List(1, 2)), Item(List(3, 4)), Item(List(4, 5)))
    println(item.map(_.lista)) //muestra una lista de items listas
    println(item.flatMap(_.lista)) //concatena las listas

    val item2 = List(List(1, 2), List(3, 4), List(4, 5))
    println(item2.flatten) //aplica para lista de listas
  }
}

//ejemplo con case class
case class Item(lista: List[Int])
