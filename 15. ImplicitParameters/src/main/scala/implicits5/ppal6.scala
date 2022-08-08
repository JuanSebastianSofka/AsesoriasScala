package implicits5

import implicits5.Apis.APIRestCustom

//supongamos algo http y json, etc
class APIRest(url: String, data: String = "") //data string json

class APIWebService(url: String, data: String) //DATA tipo html

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
    def toObject(api: APIWebService) = Producto("1", "Producto de api web service")
  }
}

//implementamos la interfaz en lo anterior y aqui estamos manejando la forma de desligarse de lo anterior permitiendo recibir n tipos basados en la API
//esto se basa en los principios solid de segregar interfaces
object APIUtil {
  def toObject[T, D](api: T)(implicit customApi: API[T, D]) = {
    customApi.toObject(api)
  }
}

object ppal6 {
  def main(args: Array[String]): Unit = {
  ejemplo3()
  }

  //tomando segundo parametro del object de manera implicita
  def ejemplo3(): Unit = {
    val apiRest = new APIRest("http://sdfsd")
    val producto = APIUtil.toObject(apiRest) //se pasa el segundo parametro de forma implicita

    println(producto)
  }

}
