package eitherErrores
trait BaseError{
  val descrpcion: String
}

trait ErrorTecnico extends BaseError
trait ErrorNegocio extends BaseError

case class ErrorBasedeDatos(descrpcion: String = "Ocurrió un error integrandonos con la bd") extends ErrorTecnico

case class ClienteDuplicado(descrpcion: String = "Cliente ya existe") extends ErrorNegocio
case class ClienteNoExiste(descrpcion: String = "Cliente no Existe") extends ErrorNegocio

case class Cliente(id: String, nombre: String)

trait Repositorio[T]{
  def actualizar(objeto: T): Either[BaseError, Cliente]
}


object Repositorio extends Repositorio[Cliente] {
  override def actualizar(objeto: Cliente): Either[BaseError, Cliente] = {

    if(objeto == null){
      Left(ErrorBasedeDatos())
    }else{
      //supongamos que queremos buscar el cliente en algun lado
      if(objeto.id == "123"){
        Left(ClienteDuplicado())
      }else{
        Right(objeto)
      }
    }
  }
}

object PpalEjemploEither {
  def main(args: Array[String]): Unit = {

    //supongamos que esto es el llamado al servicio
    val resultadoCliente = Repositorio.actualizar(Cliente("55","Juan"))

    //si viene con un Left él programa no trataría de hacer esto que se hizo
    //Siempre se asume que Right es el lado bueno
    resultadoCliente.map(resultado => resultado.copy(nombre = "Juaco"))

    val resultado = resultadoCliente match {
      case Left(error) => error.descrpcion
      case Right(value)=> s"El cliente se actualizo ${value.id}"
    }

    println(resultado)
  }
}
