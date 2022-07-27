object Expresiones {

  //formas de hacer las expresiones
  def sumar(a: Int,b:Int) = a+b

  def resta(a: Int,b:Int) = a

  def suma2(a: Int,b:Int) = (a+b)

  def suma3(a: Int,b:Int) = {
    val c = 1
    a + b + c //este es el return ya que es la última línea de la función
    //si es Unit no retorna nada, como el void

    //si lo hago en una sola linea
    /*
    Separo las expresiones con ;
    def suma3(a: Int,b:Int) = {val c = 1; a+b+c}
     */
  }


}
