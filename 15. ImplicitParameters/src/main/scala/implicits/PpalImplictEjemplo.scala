package implicits

import scala.concurrent.ExecutionContext.Implicits.global //es un implicito
import scala.concurrent.Future

//los implicitos comumnete los encontramos en el package object o en los imports

object PpalImplictEjemplo {
  def main(args: Array[String]): Unit = {
    ejemplo1()
  }

  //ejemplo cotidiano
  def ejemplo1(): Unit ={
    /*val cadena: String = "1"

    //así como está el copmpilador marca error porque estamos asignando un string a un int
    val entero: Int = cadena

    println(entero)*/

    //--------------------------------------------------------------------------------------------------------------
    //usando implicitos ya no marca error porque ya cada objeto tiene una definicion implicita por el packageobject
    //si usaramos el metodo toInt es explicita
    val cadena: String = "1"
    val entero: Int = cadena //toma valor de 2 que es lo que le pasamos en el package object

    println(entero)
  }

  //future tambien necesita implicitos y le importamos el global
  def ejemplo2(): Unit ={
    val future = Future(2)
  }
}
