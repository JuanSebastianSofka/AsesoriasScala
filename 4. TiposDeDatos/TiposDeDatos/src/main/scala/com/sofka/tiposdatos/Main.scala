package com.sofka.tiposdatos

import com.sofka.tiposdatos.casteo.Casting

object Main {
  def main(args: Array[String]): Unit = {
    //imprimirLista()
    Casting.casting()
  }

  def imprimirLista(): Unit = {
    println(Tipos.crearLista())
  }

}
