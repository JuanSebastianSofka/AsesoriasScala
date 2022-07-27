package typeAlias

import typeAlias.TypeAliasEjemplo.{Matriz, Vector, sumarVigencia}

object TypeAliasEjemplo {
//pensando en el negocio seria así
  type sumarVigencia = Int =>Int //una lambda que recibe un entero y devuelve un entero

  //usando alias para una matriz
  type Vector = List[Int]
  def Vector(items: Int*)= List(items: _*) //el asterisco indica que puedo recibir 1 o muchos items
  type Matriz = List[Vector]
  def Matriz(items: Vector*)= List(items: _*)
}

trait Funciones{
  //esto es engorroso y "da miedo" y desde el negocio no tiene sentido
  /*def calcular(a: Int, f: Int=>Int)={
    f(a)
  }*/

  //la forma usando el tipe anterior seria
  def calcular(a: Int, f: sumarVigencia)={
    f(a)

    //usando la matrix
    val matriz = Matriz(
      Vector(1,2,3),
      Vector(1,2,3)
    )
  }
}
