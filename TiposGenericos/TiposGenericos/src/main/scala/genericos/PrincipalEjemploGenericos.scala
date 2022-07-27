package genericos

//implementacion en trait
trait CustomTrait {
  def funcion[T](dato: T): String = {
    s"$dato"
  }
}

object CustomTrait extends CustomTrait

//trait con dos tipos genericos
trait TipoGenerico[E, R] { //E: Entrada, R: Retorno
  def g(a: E, f: E => R): R = f(a)

  //haciendo sobrecarga
  def g(a: E, b: E, f: E => R): R = f(a)

  //haciendo sobrecarga, pero este ultimo no lo permite porque piensa que pueden tener el mismo tipo
  //def g(a: R, f: R => E): E = f(a)
  def h(a: R, f: R => E): E = f(a)
}

object TipoGenerico extends TipoGenerico[Int, String] //defino los tipos del trait

object PrincipalEjemploGenericos {
  def main(args: Array[String]): Unit = {

    println(funcion(1)) //infiere el tipo de dato en tiempo de compilacion
    println(funcion("Hola"))
    println(CustomTrait.funcion(1))

    println(TipoGenerico.g(4, a => a.toString))
    println(TipoGenerico.h("8", a => a.toInt))
  }

  //definiendo función genérica
  def funcion[T](dato: T): String = {
    s"$dato"
  }
}
