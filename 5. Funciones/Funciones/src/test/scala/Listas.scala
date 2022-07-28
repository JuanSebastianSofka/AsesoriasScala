object Listas {
  def crearLista(): Unit = {
    val lista: List[Int] = List.range(1, 10)

    //formas de hacer una funcion anonima
    lista.filter(x => x % 2 == 0)
    lista.filter((x: Int) => x % 2 == 0)

    //otra forma
    lista.filter(_ % 2 == 0) //no es muy vista
  }

  //--------------------------------------------
  //Funciones de orden superior
  //F recibe un entero y devuelve un entero
  def calcularX(a: Int, f: Int => Int) = {
    f(a)
  }

  def calcularY(a: Int, f: (Int, Int) => Int) = {
    f(a, _) //devuelve una funcion porque no enviamos parámetro para el segundo valor
    //esto a su vez es una función parcialmente aplicada, ya que no le enviamos todos los parámetros
  }

  //----------------------------------------------------------
  //Curring Functions
  def curring1(a: Int) = (b: Int) => a + b

  //otra forma. esta forma exige los dos parámetros en la misma línea
  def curring2(a: Int)(b: Int) = a + b

  //----------------------------------------------------------
  //Closure
  var iva = 16

  def calcularIva(valor: Int) = {
    valor * (iva / 100)
  }

  //----------------------------------------------------------
  //Funciones parciales y totales

  def lista(): Unit = {
    val listaInside: List[Int] = Nil
    //son seguras
    listaInside.take(1)
    listaInside.drop(1)

    //no son seguras
    listaInside.tail(1) //
  }

  //------------------------
  //parámetros por defecto
  def sumar(a: Int = 2, b: Int = 3) = a + b

  //parámetros por defecto
}
