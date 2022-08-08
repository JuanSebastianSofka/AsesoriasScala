import scala.language.implicitConversions

package object implicits extends ConvertidorCliente {

  implicit def cadenaAEntero(cadena: String) : Int = 2

  type id = String
}

