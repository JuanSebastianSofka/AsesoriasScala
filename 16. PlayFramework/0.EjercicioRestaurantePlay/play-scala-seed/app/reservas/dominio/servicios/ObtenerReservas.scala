package reservas.dominio.servicios

import reservas.dominio.modelo.{Reserva, Reservado}

import java.util.Date
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

trait ObtenerReservas {

  def obtenerReserva(id: String) : Future[Reserva] = Future {
    Reserva("123", "Juan", new Date().toString, Reservado())
  } //importamos el implicito globak

}

object ObtenerReservas extends ObtenerReservas
