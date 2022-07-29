//asi lo vuelvo mutable
//import scala.collection.mutable.Map

object PpalMapasEjemplos {
  def main(args: Array[String]): Unit = {
    ejemploMapa()
    otraFormaDeDeclararlos()
  }

  def ejemploMapa(): Unit = {
    val map = Map(
      (1, "Juan"),
      (2, "Franco"),
      (3, "Cervera")
    )

    println(map)
  }

  def otraFormaDeDeclararlos(): Unit = {
    val map = Map(
      1 -> "Juan",
      2 -> "Franco",
      3 -> "Cervera"
    )

    println(map)
  }
}
