package optional.ejemplo2

import scala.concurrent.Future

//para convertir por asi decirlo de entidad a DTO y viseversa
trait Transformador[D, A] { //Dominio a A y de A a Dominio
  def transformarDaA(objeto: D): A

  def transformarAaD(objeto: A): D
}

//uniendo ocn Either
trait Repo {
  //si la derecha devuelve vacio es porque no lo encontró, es decir no lo puedo actualizar
  // pero como tal no arroja error
  def actualizar(cliente: Cliente): Either["Errores bla bla bla", Option[Cliente]]

  //si la derecha devuelve vacio es porque no lo encontró, es decir no hago un get,
  // pero como tal no arroja error
  def consultar(id: String): Either["Errores bla bla bla", Option[Cliente]]

  def guardar(): Future[Either["sdfsdfd", Option[Cliente]]] //esto ya es otro tema a ver Xd
}

//Esto es cuando en el Json que da una persona le decimos que si no envía X datos sigue funcionando
case class ClienteDTO(
                       documento: String,
                       nombre: String,
                       numeroCasa: Option[String],
                       numeroTrabajo: Option[String]
                     )

case class ClienteACL(
                       documento: String,
                       nombre: String,
                       numeroCasa: String,
                       numeroTrabajo: String
                     )

//Esta es la entidad como tal con el que hacemos las reglas de negocio
case class Cliente(
                    documento: String,
                    nombre: String,
                    numeroCasa: Option[String],
                    numeroTrabajo: Option[String]
                  )

//Esto es lo que representaria la tabla de la base de datos que pueden tener nulos
case class ClienteData(
                        documento: String,
                        nombre: String,
                        numeroCasa: Option[String],
                        numeroTrabajo: Option[String]
                      )

//El option es demasiado utilizado
object PpalEjemploOption2 {
  def main(args: Array[String]): Unit = {

    //Caso mas critico es en el negocio
    val lista = List(
      Cliente("123", "Juan", Option.empty, Option.empty),
      Cliente("456", "Juan", Some("134654"), Option.empty),
      Cliente("789", "Juan", Option.empty, Some("564651365"))
    )

    val listaProcesada = validarNumerosTelefonos(lista)
    val clienteOpt = consultar("789", lista) //si envio un id que no existe devuelve la linea 50

    println(s"${
      clienteOpt
        .map(cliente => cliente.numeroCasa.getOrElse("El cliente no tiene teléfono fijo"))
        .getOrElse("El cliente no existe")
    }")

    println(s"${clienteOpt.flatMap(_.numeroCasa).getOrElse("El cliente no existe o no tiene numero fijo")}")


    println(listaProcesada)

    //convirtiendo de opcional a ACL indicando que si hay algo lo ponga y si no dejelo nulo
    clienteOpt
      .map(
        cliente => ClienteACL(cliente.documento,
          cliente.nombre,
          cliente.numeroCasa.orNull,
          cliente.numeroTrabajo.orNull))


    //orientado al dominio
    val clienteACL = ClienteACL("", "", null, null)

    Cliente(
      clienteACL.documento,
      clienteACL.nombre,
      Option(clienteACL.numeroCasa),
      Option(clienteACL.numeroTrabajo))
  }

  def consultar(idCliente: String, clientes: List[Cliente]) = {
    clientes.filter(_.documento.equals(idCliente)).headOption
  }

  def validarNumerosTelefonos(clientes: List[Cliente]) = {
    clientes.filter(cliente => !cliente.numeroCasa.isEmpty)
  }

  def validarNumerosTelefonos2(clientes: List[Cliente]) = {
    clientes.filter(cliente => cliente.numeroCasa != null && cliente.numeroCasa.isEmpty)

    clientes.filter(cliente => validarNulo(cliente.nombre))
  }

  //mas elegante
  def validarNulo(valor: String) = {
    valor != null && valor.isEmpty
  }
}
