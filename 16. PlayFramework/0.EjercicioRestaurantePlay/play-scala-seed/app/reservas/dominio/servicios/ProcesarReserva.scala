package reservas.dominio.servicios

import reservas.dominio.modelo.{Reserva, Reservado}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

trait ProcesarReserva {

  def crearReserva(reserva: Reserva) : Future[Reserva] = Future {
    reserva.copy(estado = Reservado())
  } //importamos el implicito globak
}

object ProcesarReserva extends ProcesarReserva
