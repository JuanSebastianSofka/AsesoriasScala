object Main {
  def main(args: Array[String]): Unit = {

    //Funciones de orden superior
    println(Listas.calcularX(10, (a: Int) => a + 1))
    println(Listas.calcularY(10, (a: Int, b: Int) => a + b)(7))//recibimos la función y asignamos el valor a B

    //desglosando el calculaY
    val f = Listas.calcularY(10, (a: Int, b: Int) => a + b)
    println(f(7))
  //-----------------------------------------------------------
    //curring
    val fCurring = Listas.curring1(10) //el segundo parámetro no es obligatorio
    println("aqui retorno una lambda" + fCurring)
    //retorna el objeto de tipo función porque le falta el segundo parámetro

    //aqui ya le pasamos el segundo parámetro
    println("fcurring: " + fCurring(5))

    //si quiero enviar ambos parámetros
    val fCurring2 = Listas.curring1(10)(9)
    println("fcurring2: " + fCurring2)

    //con la segunda forma de curring
    val segundaFormaCurring = Listas.curring2(10)(8) //el segundo parámetro es obligatorio
    println(segundaFormaCurring)

    //haciendolo opcional en la segunda manera
    val segundaFormaCurring2 = Listas.curring2(10)_ //el segundo parámetro es obligatorio
    println(segundaFormaCurring2(2))


    //parametro con nombre puede ser lo siguiente
    //val fCurring = Listas.curring1(a = 10)

    //funciones como objeto
    //val fCurring = Listas.curring1(a = 10) ... el mismo ejemplo anterior es una funcion como objeto
  }
}
