package reservas.infraestructura.controladores

import play.api.libs.json.Json
import play.api.mvc.{BaseController, ControllerComponents}
import reservas.dominio.servicios.ObtenerReservas
import reservas.infraestructura.controladores.DTO.ReservaDTO

import javax.inject.Singleton
import scala.concurrent.ExecutionContext.Implicits.global

//las clases deben ser singleton, y debemos extender de base controller. AL extener de este debemos a la clase asignar una variable de tipo
//ControllerCOmponents. Se usa para poder tener un buen uso a los servivcios
@Singleton
class ControladorReserva(val controllerComponents: ControllerComponents) extends BaseController{

  //se usan los Action porque el BaseControler lo usa para saber que recibe y que devuelve
  //usamos async de asuncrono, y espera que le pasemos un futuro
  //este async debe deolver una construccion de la accion que se traduce a http usando map

  def obtenerReserva(id: String) = Action.async {
    //si el futuro no falla, devuelve un ok

    /*ObtenerReservas.obtenerReserva(id)
      .map(reserva => {
        Ok("") //ok es http 200, y recibe strings, y de momento enviamos "", pero la idea es enviar la reserva serializada, usando el package
      }) //añadimos el implicito global*/

    ObtenerReservas.obtenerReserva(id)
      .map(reserva => {
        val reservaDto: ReservaDTO = reserva

        //val json = Json.obj("data"-> reservaDto) //importamos el json de play.api

        //otra forma de json, las dos, esta y la anterior funcionan

        val json = Json.toJson(reservaDto) //importamos el json de play.api
        Ok(json) //ok es http 200, enviamos el json serializado
      }) //añadimos el implicito global
  }
}
