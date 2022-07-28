package patternMatching

sealed trait Persona

case class Cliente(doc: String, nombre: String) extends Persona
case class Vendedor(doc: String, nombre: String) extends Persona
case class Proveedor(doc: String, nombre: String) extends Persona

object PpalEjemploPattern {

  type Funcion = Int => Int

  def main(args: Array[String]): Unit = {
    val persona: Persona = Cliente("4563645", "Juan")
    matching(persona)

    val f: Funcion = a => a + 1
    ejemploTipo(f)
  }

  def matching(persona: Persona) = {

    //aplicando la coincidencia de patrones validando el tipo
    persona match {
      case cliente: Cliente => println(s"Es un cliente: $cliente")
      case vendedor: Vendedor => println(s"Es un vendedor: $vendedor")
      case proveedor: Proveedor => println(s"Es un proveedor: $proveedor")
      case _ => println("Sin coincidencias")
    }

    //otra forma basandose propiamente en el tipo
    persona match {
      case Cliente(_, nombre) => println(s"Es un cliente: $nombre")
      case _ => println("Sin coincidencias")
    }

    //usando if
    persona match {
      case Cliente(_, nombre) if nombre == "Juan" => println(s"Es un cliente: $nombre")
      case vendedor: Vendedor => println(s"Es un vendedor: $vendedor")
      case proveedor: Proveedor => println(s"Es un proveedor: $proveedor")
      case Vendedor(_, _) | Proveedor(_, _) => println("Es un vendedor o un proveedor")
      case _ => println("Sin coincidencias")
    }
  }

  //unificando ambos
  def color(): Unit = {
    val color = "rojo"

    color match {
      case "Negro" | "Blanco" => println("Es blanco o rojo")
      case "Rojo" => println("Es rojo")
      case _ => println("Sin coincidencias")
    }
  }

  //coincidencias de tipos propios de scala
  //el valor por default siempre va al final
  def ejemploTipo(tipo: Any): Unit = {
    tipo match {
      case s: String => println(s"Es un string $s")
      case l: List[_] => println(s"Es una lista $l")
      case m: Map[_, _] => println(s"Es un map $m")
      case (a, b, c) => println(s"es una tupla de 3 elementos $a")
      case f: Funcion => println(f(1))
      case _ => println("Sin coincidencias")
    }
  }
}
