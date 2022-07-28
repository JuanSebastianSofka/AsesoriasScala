package com.sofka.tiposdatos.casteo

object Casting {
  def casting(): Unit ={
    val x: Long=9876545
    val y: Float= x //paso de long a float

    val face : Char = 'a'
    val number: Int = face //me devuelve el numero del codigo ascii de ese Char

    //cosas que no puedo hacer
    //val k:Int = x//no puedo pasar de long a int

    //val n:Float = null //esto tampoco lo puedo hacer
    println(number)
  }

}
