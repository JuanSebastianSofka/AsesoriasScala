package implicits

case class Cliente(id: id, nombre: String)

case class ClienteDTO(id: id, nombre: String)


object Ppal2 {
  implicit  val iva: Double = 0.16
  def main(args: Array[String]): Unit = {
    ejemplo(ClienteDTO("1", "Juan"))
  }

  def ejemplo(clienteDTO: ClienteDTO): Unit = {
    val cliente: Cliente = clienteDTO //se arregla el error por el convertidor que extendimos en el package
    println(cliente)
  }

  //pasar implicito por parámetro
  def ejemplo2(): Unit ={
    val valorImpuesto = CalculadorImpuestos.calcularIva(1000)(0.19) //es "bobada" crear el implicito cuando el numero esta siendo explicito

    val valorImpuesto2 = CalculadorImpuestos.calcularIva(1000) //si definimos el implicito arriba ya lo captura bien
    println(valorImpuesto)
    println(valorImpuesto2)
  }

}
