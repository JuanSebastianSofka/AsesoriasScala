package implicitos4

//supongamos algo http y json, etc
class APIRest(url: String, data: String = "") //data string json

class APIWebService(url: String, data: String) //DATA tipo html

case class Producto(id: String, nombre: String)

trait API[T, D] {
  def toObject(api: T) : D
}


//CONVERTIR DE LA REST AL OBJETO PRODUCTO
object APIRestCustom extends API[APIRest, Producto] {
  def toObject(api: APIRest) = Producto("1", "Producto de api rest")
}

object APIWebServiceCustom extends API[APIWebService, Producto] {
  def toObject(api: APIWebService) = Producto("1", "Producto de api web service")
}

//implementamos la interfaz en lo anterior y aqui estamos manejando la forma de desligarse de lo anterior permitiendo recibir n tipos basados en la API
//esto se basa en los principios solid de segregar interfaces
object APIUtil{
  def toObject[T, D] (api: T, customApi: API[T, D]) ={
    customApi.toObject(api)
  }
}

object ppal5 {
  def main(args: Array[String]): Unit = {
    //ejemploRest()
    ejemplo2()
  }

  def ejemploRest(): Unit = {
    val apiRest = new APIRest("http://sdfsd")

    val producto = APIRestCustom.toObject(apiRest)

    println(producto)

  }

  //hace las transformaciones
  def ejemplo2(): Unit ={
    val apiRest = new APIRest("http://sdfsd")
    val producto = APIUtil.toObject(apiRest, APIRestCustom) //aqui le puedo pasar CUALQUIER implementacion
    println("prodiucto resto " +producto)

    val apiWeb = new APIRest("http://sdfsd")
    val productoWeb = APIUtil.toObject(apiWeb, APIRestCustom) //aqui le puedo pasar CUALQUIER implementacion
    println("producto web " + productoWeb)
  }

  //tomando segundo parametro del object de manera implicita
  def ejemplo3(): Unit ={
    val apiRest = new APIRest("http://sdfsd")
    val producto = APIUtil.toObject(apiRest, APIRestCustom)

    println("prodiucto resto " +producto)
  }
}
