package reservas.infraestructura

import play.api.libs.json.Json
import reservas.dominio.modelo.Reserva
import reservas.infraestructura.controladores.DTO.ReservaDTO


package object controladores {

  //para el controlador, usando Json de play.api
  implicit val serializador = Json.format[ReservaDTO]

  //para conversiones
  implicit def convertirADTO(reserva: Reserva) = {
    ReservaDTO(reserva.id, reserva.nombre, reserva.fechaReserva, reserva.estado.toString)
  }
}
