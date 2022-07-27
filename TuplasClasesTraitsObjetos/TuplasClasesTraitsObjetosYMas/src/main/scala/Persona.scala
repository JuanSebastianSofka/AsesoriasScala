//es contructor y al mismo tiempo se definen los atributos de la clase Persona
//los case class no tienen herencia entre ellos, son inmutables y tienen por defecto el get y set
case class Persona(id: Int, nombre: String, activo: Boolean)

object PersonaTest {
  //NOTA: si uso el comodin inicializando las cosas con "_" inicializa la variable con el valor por defecto
  //que ese tipo soporta, y solo aplica para el var ya que es algo que modificaremos
  var nombre: String = _ //nulo
  var id: Int = _ //0
  var activo: Boolean = _ //false

  def main(args: Array[String]): Unit = {
    val tupla = (3, "pedro", false)
    val persona2 = Persona.tupled(tupla) //convierto de tupla a persona (case class)
    println("persona2: " + persona2)

    val persona1 = Persona(1, "Juan", true)
    println(persona1.nombre)
    println(persona1.id)
    println(persona1.activo)
    println(persona1)

    val persona3 = Persona(1, "Juan", _) //deberia devolver un falso en el ultimo parámetro pero (leer abajo)
    println("persona3: " + persona3) //a falta de un parámetro imprime el hash de la lambda,
    // es decir, postergó la construcción, y siempre espera que luego le metamos el falso
    println("persona3 construida: " + persona3(false))

    //la lambda del paso anterior que espera la construccion seria la siguiente
    /**
     * val persona: Boolean => Persona = Persona(1, "juan", _)
     * Si fuera string lo faltante se declara como string
     */

    //uso de copy
    val persona4 = persona1.copy(2,"Jacinto",false)
    println(persona4)

    val persona5 = persona4.copy(id=5)
    println(s"persona5 $persona5")//imprimiendo con concatenacion
  }
}



