package optional.ejemplo1

case class Alumno(
                   documento: String,
                   Nombre: String,
                   EstadoCivil: Option[String] //El estado civil puede ser nulo o string
                 )

object EjemploEstudiante {
  def main(args: Array[String]): Unit = {

    val estudiante = Alumno("12", "juan", None)
    val estudiante2 = Alumno("12", "juan", Some("Casado"))

    val estadoCivil = Option(null)
    val estudiante3 = Alumno("12", "Juan", estadoCivil)

    println("estudiante " +estudiante.EstadoCivil) //devuelve none
    estudiante2.EstadoCivil.foreach(x => println("Estudiante 2 " + x)) //devuelve el estado civil "Casado"
    println("Estudiante 3 " + estudiante3.EstadoCivil) //devuelve none

    println("Funcion completa " + funcion(1, Some(2)))
    println("Funcion incompleta " + funcion(5, None))

    val resultado = funcion(5, _)
    println("Lambda de la funcion incompleta" + resultado) //asi devuelve la lamda, es decir "deja la construccion para despues"
    println("Complenatndo la lambda " + resultado(Some(2))) //asi completamos la lambda

  }

  //funcino con optional
  def funcion(a: Int, b: Option[Int]) = {
    b.map(_ + a).getOrElse(0)
  }
}
