package implicits2

object Extensibilidades {
  implicit class CustomString(cadena: String) {
    def miLength() = cadena.length //de manera academica porque XD

    //en sura es util esto
    def toBoolean() = cadena.equals("S") //o "N"

  }


}
