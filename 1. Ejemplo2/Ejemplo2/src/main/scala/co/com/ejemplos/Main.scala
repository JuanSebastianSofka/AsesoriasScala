package co.com.ejemplos

object Main {
  def main(arg: Array[String]) = {

    //lamar una funcion normal
    println(Funciones.sumar(1, 1))

    //funcion tratada como objeto y pasarla a otra función
    val f: (Int, Int) => Int = Funciones.sumar

    //la función puedo usarla
    println(f(2, 2))
    //o puedo enviarla como parámetro
    println(Funciones.sumarConFuncins(1, 1, f))

    val fIncompleta = f(5, _) //indico que el segundo parametro está en espera
    println(fIncompleta(10)) //DEBE IMPRIMIR 15

    //---------------
    //composiciones de funciones F(G(x)
    val resultado = Funciones.sumarle1(Funciones.toInts("10"))
    println("resultado: " + resultado)

    //Haciendo composicion de otra forma. Debe de dar 3 el "_" es para decirle que de momento no
    //le enviaré parámetros, si no lo pongo es porque debo enviar los parametros directamente asi
    //Funciones.toInts("2")
    val convertirYSumar = Funciones.sumarle1 _ compose Funciones.toInts
    println("convertirYSumar: " + convertirYSumar("2"))


    //otra forma de composicion usando andThen. Debe de dar 5
    val resultado3 =  Funciones.toInts _ andThen Funciones.sumarle1
    println("rsultado3: " + resultado3("4"))
  }
}
