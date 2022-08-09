package reservas.dominio.modelo

trait EstadoReserva

case class Reservado() extends EstadoReserva
case class Rechazada() extends EstadoReserva
case class SinEstado() extends EstadoReserva

case class Reserva(id: String, nombre: String, fechaReserva: String, estado: EstadoReserva)
