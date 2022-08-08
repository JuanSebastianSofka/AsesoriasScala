package implicits2

import implicits2.Extensibilidades.CustomString //importamos la funcion nueva


object Ppal3 {
  def main(args: Array[String]): Unit = {
    ejemplo()
  }

  //tercer tipo. Extensibilidad
  def ejemplo(): Unit ={
    val cadena = "1234"

    println(cadena.miLength)
  }

}
