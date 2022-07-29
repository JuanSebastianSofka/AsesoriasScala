case class Curso(){
  private val privado: Int=0 //no son acesibles directamente
  protected val protegida: Int = 0 //no son acesibles directamente
  val public: Int = 0
}

class Asignatura() extends Curso{
  def ejemplo(): Unit ={
    val xx = protegida + 1 //extendiendo puedo usar las protegidas
  }
}

object PpalModificadoresEjemplo {
  def main(args: Array[String]): Unit = {
    val curso = new Curso()
    print(curso.public) //por defecto es publico

    val asignaruta = new Asignatura()
    asignaruta.public //desde aqui solo puedo ver el publico, pero usando el metodo ejemplo accedo a protegida

    //Para parametros si lo asignamos normal no es accesible, pero si antes de la asignacion le colocamos var
    //o val ya es accesible
    //case class Curso(var parametro: String){
  }

}
