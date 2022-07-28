package co.com.ejemplos

object Funciones {
  //funcion pura, idempotente y tiene transparencia referencial

  /**
   * Es pura porque no estamos modificando nada que no sea su alcance
   * idempotente porque siempre va a devolver los mismos resultados
   * y trasnparente es porque podemos reemplazar por cualquier valor los parametros
   */
  def sumar(a: Int, b: Int) = a + b

  //parámetros opcionales
  //sino me envian el parámetro tomará valor de 2
  def sumarParametroOpcional(a: Int, b: Int = 2) = a + b

  //el ultimo parametro es la funcion lambda
  def sumarConFuncins(a: Int, b: Int, f: (Int, Int) => Int) = {
    a + b + f(1, 1)
  }

  //funcion segmentada donde tengo que usar si o si a y b, y c y d son opcionales
  def operacionCompleja(a: Int, b: Int)(c:Int, d:Int) = {
    a + b+ c+ d
  }

  def toInts(cadena: String) = cadena.toInt

  def sumarle1(a:Int) = a + 1
}
