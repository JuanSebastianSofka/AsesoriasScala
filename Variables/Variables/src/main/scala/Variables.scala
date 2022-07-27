object Variables {
  def main(args: Array[String]): Unit = {
    var a: Int = 5;
    println(a)
    a = 8
    println(a);

    val b: Int = 6;
    //b = 8; //es un error porque val es inmutable

    //----------------------------------------
    //Modo Lazy
    lazy val x = 8; //No ocupan memoria hasta que son utilizados
    lazy val numero = 10/0 //no se ejecuta hasta que use este valor, de momento no la evalua
  }
}
