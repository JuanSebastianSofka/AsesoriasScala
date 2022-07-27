package tryerrores

import scala.util.Try

trait Errores {
  def dividir(a: Int, b: Int): Float = a / b

  def dividir2(a: Int, b: Int): Float = {
    if (b == 0) {
      throw new Exception("No se puede dividir por cero")
    }
    a / b
  }

  def dividir3(a: Int, b: Int): Try[Float] = Try(a / b)
}

object Errores extends Errores

object PpalEjemploTry {
  def main(args: Array[String]): Unit = {

    //println(Errores.dividir2(1, 0))

    //controlando el error
    try {
      println("Viene de try catch normal " + Errores.dividir(10, 2))
    } catch {
      case error: ArithmeticException => println(error)
    }

    val resultado = Errores.dividir3(1, 0)
    println("viene de la clase Try " + resultado.map(_ + 2).getOrElse(0))
    //el "_" reprensenta tambien x => x, es decir el map por dentro dice x=>x+2


    //asi me preocupo mas por el resultado
    if(resultado.isSuccess){
      //...code
    }
  }
}
