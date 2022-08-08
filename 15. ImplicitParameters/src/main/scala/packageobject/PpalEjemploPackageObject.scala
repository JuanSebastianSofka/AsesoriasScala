package packageobject

object PpalEjemploPackageObject {
  def main(args: Array[String]): Unit = {
    ejemplo1()
    ejemplo3toString()
  }

  def ejemplo1(): Unit = {
    val miString: MiString = "Hola" //tengo acceso al type alias sin hacer imports ni nada extra
    println(miString)
  }

  def ejemplo2Trait(): Unit = {
    println(version) //llamo a la funcion directamente por esstar en el package object
  }

  def ejemplo3toString(): Unit = {
    println(convertirAString("5"))
  }
}
