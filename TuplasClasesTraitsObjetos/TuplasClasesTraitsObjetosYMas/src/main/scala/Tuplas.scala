object Tuplas {
  //crear tupla. Son inmutables entonces solo puedo acceder mas no editar sus propiedades
  //puedo tener tambien una tupla de tuplas
  def crearTupla() = {
    val tupla = (1, "juan", Boolean, (2, ""))
    tupla
  }

  def main(args: Array[String]): Unit = {
    val tupla = crearTupla()
    println(crearTupla())
    println("elemento uno de la tupla: " + tupla._1) //para acceder a los elementos de la tupla

    //accedo a la tupla y al valor uno de la tupla interna
    println("accediendo al valor interno de la tupla" + tupla._4._1)
  }

}
