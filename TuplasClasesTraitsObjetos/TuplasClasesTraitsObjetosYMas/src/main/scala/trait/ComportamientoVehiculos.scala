package `trait`

//nota en un mismo archivo tengo la interfaz, el objeto y demas, a diferencia de java que cada
//cosa es un archivo

//indicar traits multiples
trait A
trait B
trait C

trait ComportamientoVehiculos {
  //las primeras dos funciones tienen cuerpo, y no son obligatorias de usar
  def arrancar(): Unit ={
    println("Arrancar")
  }
  def frenar(): Unit ={
    println("frenar")
  }
  def obtenerMotor(): String //funcion sin cuerpo, cuando es así es de obligatoria implementacion
}

//el object le da vida al trait, es una de las formas
//el object es singleton mientras que la clase no, entonces es más aceptado el tema de inmutabilidad
//usando with tenemos traits múltiples
//Si un objeto o clase implementa una interfaz y no le da uso hay algún error en el diseño del código
object ComportamientoVehiculos extends ComportamientoVehiculos with A with B with C {
  override def obtenerMotor(): String = ""
}

//otra es con una clase. Nota, el var y val por defecto es publico y por ende tengo acceso a id
//sin var es privado y no puedo acceder
//si es val, es una forma de get y no puedo mofidicar, con var
class Aveo(var id: String)extends ComportamientoVehiculos {
  override def obtenerMotor(): String = ""
}

object PrincipalTraits{
  def main(args: Array[String]): Unit = {
    ComportamientoVehiculos.arrancar() //parece asi un metodo estatico de java
    ComportamientoVehiculos.frenar()
    ComportamientoVehiculos.obtenerMotor()

    //creamos instancia de la clase para usar la interfaz a partir de la clase
    val aveo = new Aveo("7")
    println(aveo.id)
  }
}

