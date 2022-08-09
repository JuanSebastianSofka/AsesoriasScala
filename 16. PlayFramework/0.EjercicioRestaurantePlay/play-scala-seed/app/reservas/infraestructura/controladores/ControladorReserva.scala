package reservas.infraestructura.controladores

import play.api.Logger
import play.api.libs.json.Json
import play.api.mvc.{BaseController, ControllerComponents}
import reservas.dominio.servicios.{EliminarReserva, ObtenerReservas, ProcesarReserva}
import reservas.infraestructura.controladores.DTO.ReservaDTO

import javax.inject.{Inject, Singleton}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

//las clases deben ser singleton, y debemos extender de base controller. AL extener de este debemos a la clase asignar una variable de tipo
//ControllerCOmponents. Se usa para poder tener un buen uso a los servivcios

//añadimos el inject para la injeccion de dependencias
@Singleton
class ControladorReserva @Inject()(val controllerComponents: ControllerComponents) extends BaseController {
  val logger: Logger = Logger("ControladorReserva")
  //se usan los Action porque el BaseControler lo usa para saber que recibe y que devuelve
  //usamos async de asuncrono, y espera que le pasemos un futuro
  //este async debe deolver una construccion de la accion que se traduce a http usando map

  def obtenerReserva(id: String) = Action.async {
    //si el futuro no falla, devuelve un ok

    /*ObtenerReservas.obtenerReserva(id)
      .map(reserva => {
        Ok("") //ok es http 200, y recibe strings, y de momento enviamos "", pero la idea es enviar la reserva serializada, usando el package
      }) //añadimos el implicito global*/

    /*ObtenerReservas.obtenerReserva(id)
      .map(reserva => {
        val reservaDto: ReservaDTO = reserva

        //val json = Json.obj("data"-> reservaDto) //importamos el json de play.api

        //otra forma de json, las dos, esta y la anterior funcionan

        val json = Json.toJson(reservaDto) //importamos el json de play.api
        Ok(json) //ok es http 200, enviamos el json serializado
      }) //añadimos el implicito global*/

    //para el nuevo commit con el some y none
    ObtenerReservas.obtenerReserva(id)
      .map(reservaOpt => {
        reservaOpt.map(reserva => {
          val reservaDto: ReservaDTO = reserva

          //val json = Json.obj("data"-> reservaDto) //importamos el json de play.api

          //otra forma de json, las dos, esta y la anterior funcionan

          val json = Json.toJson(reservaDto) //importamos el json de play.api
          Ok(json) //ok es http 200, enviamos el json serializado
        }).getOrElse(NotFound("No existe la reserva"))

      }).recover {
      case ex =>
        logger.error("Ocurrio un error en el servicio obtenerReserva", ex)
        InternalServerError("Ocurrio un error interno")
    } //añadimos el implicito global
  }

  //solo aceptamos json con el parse.json
  def crearReserva() = Action.async(parse.json) {
    request =>
      //valido que el request tenga estructura json de reserva dto
      val validar = request.body.validate[ReservaDTO]

      validar.asEither match {
        case Left(value) => Future.successful(BadRequest(value.toString()))

        case Right(value) => ProcesarReserva.crearReserva(value) //aqui hay un error porque necesitamos el implicito que pase de dtp a dominio
          //en el package
          .map(reserva => {
            val reservaDTO: ReservaDTO = reserva
            val json = Json.toJson(reservaDTO)
            Ok(json)
          }).recover {
          case ex =>
            logger.error("Ocurrio un error en el servicio obtenerReserva", ex)
            InternalServerError("Ocurrio un error interno")
        } //añadimos el implicito global
      }
  }

  //put es igual a crear
  //delete es igual a obtener solo que con el metodo de eliminar

  def eliminarReserva(id: String) = Action.async {

    EliminarReserva.eliminarReserva(id)
      .map(reserva => {
        val reservaDto: ReservaDTO = reserva
        val json = Json.toJson(reservaDto) //importamos el json de play.api
        Ok(json) //ok es http 200, enviamos el json serializado

      }).recover {
      case ex =>
        logger.error("Ocurrio un error en el servicio obtenerReserva", ex)
        InternalServerError("Ocurrio un error interno")
    } //añadimos el implicito global
  }
}
