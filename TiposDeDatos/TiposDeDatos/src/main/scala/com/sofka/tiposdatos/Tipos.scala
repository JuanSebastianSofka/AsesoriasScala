package com.sofka.tiposdatos

object Tipos {

  //puedo indicar que es de tipo Unit, pero si lo quito, la propia función intuye lo que devuelve
  def f(a: Int, b: Int): Unit = {
    println(a + b)
  }

  //usando el any, la lista es de tipo Any, sin embargo se recomienda no usar Any ya que es muy genérico
  def crearLista() = {
    val lista: List[Any] = List(
      "esto es un string",
      123,
      true,
      () => "mi funcion"
    )
    lista //esto seria el return
  }
}
//otra forma es hacerlo directamente asi
/**
 * List(
 * "esto es un string",
 * 123,
 * true,
 * ()=>"mi funcion"
 * )
 * }
 * }
 */