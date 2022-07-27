package companionObject

class Estudiante(var nombre: String)

object Estudiante{
  //para darle un comportamiento estaitco
  def imprimirEsrudiante(): Unit ={
    println("Hola estudiante")
  }

  def apply(nombre: String)= new Estudiante(nombre: String) //constructor, hay veces que TOCA usarlo si o si
  //por ejemplo cuando nos conectamos a una base de datos para convertir de base de datos a dominio
  //Y de dominio a base de datos
}

object Ppal{
  def main(args: Array[String]): Unit = {

    Estudiante.imprimirEsrudiante() //accedo directamente a la clase sin crear un objeto

    val estudianteConConstructor = Estudiante("Pedro") //viene de la linea 11, no usamos el "new" ya que usamos
    //directamente el apply como constructor

    println(estudianteConConstructor.nombre)
    println(estudianteConConstructor) //imprime el hashCode del objeto
  }
}
