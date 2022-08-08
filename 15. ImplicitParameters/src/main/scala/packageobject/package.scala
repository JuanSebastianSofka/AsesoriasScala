//representa al paquete de afuera "packageobject"

//esta disponible para todo lo que tengamos
package object packageobject extends Versionador {

  type MiString = String //estará disponible implicatemente dentro del paquete

  def convertirAString[T](valor: T) = valor.toString
}
