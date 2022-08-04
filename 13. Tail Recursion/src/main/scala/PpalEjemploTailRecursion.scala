import scala.annotation.tailrec

object PpalEjemploTailRecursion {
  def main(args: Array[String]): Unit = {
    //sumatoria1(10)
    println(sumatoria2(5))
  }

  //funciones recursiva para sumar
  //es peligrosa por las llamadas que quedan pendientes
  def sumatoria1(n: Int): Long = {
    if (n == 0) {
      println("Terminó")
      n
    } else {

      //apila el resultado, si el numero es muy grande como un 10000000000 reviente porque la pila de llamadas es demasiada
      n + sumatoria1(n - 1)
    }
  }

  //tailRecursion ejemplo para evitar llevar el llamado interno de la funcion a una pila
  //le pasamos un resultado directamente
  //es como si volviera la funcion en una lista y la suma [1, 2, 3, 4, 5]

  @tailrec //la etiqueta hace que se vea un mensaje en compilación de decirte si la funcion si es tal o no
  def sumatoria2(n: Int, resultado: Long = 0): Long = {
    if (n == 0) {
      println(s"Terminó $n")
      resultado //aqui devuelve el total real de la suma
    } else {
      println(s"Calculando $n $resultado")
      sumatoria2(n - 1, n + resultado) //acumula el dato nuevo en resultado en vez de la funcion entera, no apila porque guarda en resultado
    }
  }

  //para temas acumulatimos
  def sumatoria3(n: Int): Long = {
    val lista = List.range(0, 10)

    lista.foldLeft(0L)((resultado, n) => resultado + n) //es lo mismo que lo anterior de tailRec

    lista.foldRight(0L)((n, resultado) => resultado + n) //es lo mismo que lo anterior de tailRec

  }

  //ejemplo factorial tal recursion
  def factorial(n: Int): Int = {
    @tailrec
    def iter(x: Int, result: Int): Int =
      if (x == 1) result
      else iter(x - 1, result * x)

    iter(n, 1)
  }

  println("factorial de 3 " + factorial(3))
  println("factorial de 4 " + factorial(4))
}
