package implicit6

import implicit6.Apis.{APIRestCustom, APITCPCustom, APIUtil, APIWebServiceCustom}

//supongamos algo http y json, etc
//esto es un ejemplo de la vida real

class APIRest(url: String, data: String = "") //data string json

class APIWebService(url: String, data: String = "") //DATA tipo html

class APITCP(url: String, data: String = "") //DATA tipo html

case class Producto(id: String, nombre: String)

trait API[T, D] {
  def toObject(api: T): D
}

//esto permite hacer mas flexible el código
object Apis {
  //CONVERTIR DE LA REST AL OBJETO PRODUCTO
  implicit object APIRestCustom extends API[APIRest, Producto] {
    def toObject(api: APIRest) = Producto("1", "Producto de api rest")
  }

  implicit object APIWebServiceCustom extends API[APIWebService, Producto] {
    def toObject(api: APIWebService) = Producto("2", "Producto de api web service")
  }

  implicit object APITCPCustom extends API[APITCP, Producto] {
    def toObject(api: APITCP) = Producto("3", "Producto de api TCP")
  }

  //EXTENDEMOS DE CUALQUIER API DE TIPO T
  implicit class APIUtil[T, D](api: T) {
    def toObject()(implicit customApi: API[T, D]) = {
      customApi.toObject(api)
    }
  }
}


object ppal7 {
  def main(args: Array[String]): Unit = {
    ejemplo()
  }

  //esto lo vamos a encontrar mucho. Inferir api tambien
  def ejemplo(): Unit = {
    val apiRest = new APIRest("http://sdfsd")
    val producto = apiRest.toObject()

    println(producto)

    val apiWeb = new APIWebService("http://sdfsd")
    val producto2 = apiWeb.toObject()

    println(producto2)

    val apiTCP = new APITCP("http://sdfsd")
    val producto3 = apiTCP.toObject()

    println(producto3)
  }
}
