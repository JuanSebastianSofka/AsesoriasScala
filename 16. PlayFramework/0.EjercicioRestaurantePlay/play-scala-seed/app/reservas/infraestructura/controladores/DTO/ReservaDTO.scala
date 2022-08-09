package reservas.infraestructura.controladores.DTO

import reservas.dominio.modelo.EstadoReserva

//el estado para el DTO será string para serializar mas fácil
case class ReservaDTO(id: String, nombre: String, fechaReserva: String, estado: String)
