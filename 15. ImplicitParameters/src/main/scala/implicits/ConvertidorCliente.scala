package implicits

trait ConvertidorCliente {
  //implicito para convertir
  implicit def convertirADominio(clienteDTO: ClienteDTO) = Cliente(clienteDTO.id, clienteDTO.nombre)
}
