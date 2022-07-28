package tiposAlgebraicosADT
//LIMITAN EL UNIVERSO POR EL CUAL PUEDE IR UN VALOR O VARIABLE
//Es relativamente antagonico a genericos, en genericos tengo lo que yo quiera, en ADT lo limito

//solo puede tener dos valores, una analogia es con el boolean, o es true o es false
//Se relacionan con un OR

//Relacionandolo con el ejercicio del Dron, solo puede tener los 3 datos que se muestran
//Esto es un tipo hibrido porque por un lado extiende de comando pero el puntaje puede tomar valores infinitos
//por el atributo puntaje sería de tipo producto, y por la extension es suma, por ende es hibrido
//los ADT proponen pensar en los tipos de manera mejorada y flexible


trait Comando

case class Arriba(puntaje: Int = 5) extends Comando
case class Abajo(puntaje: Int) extends Comando
case class Derecha(puntaje: Int) extends Comando

//las librerias de scala vienen con lo anterior bien interirizado
case class Configuration (a: Boolean, b: Boolean, c: Boolean) //EL CASE CLASS como tal es tipo producto y
// tipo suma individual

//para volver tipo suma
trait config
case class COnfiguracionA() extends config
case class COnfiguracionB() extends config
case class COnfiguracionC() extends config


//case class Comando(direccion: String, puntaje: Int)
object PrincipalTipoSuma {
  def main(args: Array[String]): Unit = {
    val comando = Arriba() //puede ser Arriba + Abajo + Derecha, pero no dos o tres al tiempo
    println(comando.puntaje)

    val config = COnfiguracionA()
  }

  def funcion(a:String,b: String): Unit ={

  }
}
