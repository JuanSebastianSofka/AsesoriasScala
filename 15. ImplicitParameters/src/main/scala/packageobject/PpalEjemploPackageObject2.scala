package packageobject

import java.util.{Date => DateUtil} //le damos un alias a la clase
import java.sql.{Date => SqlDate}

object PpalEjemploPackageObject2 {
  def main(args: Array[String]): Unit = {
    ejemplo1()
  }

  def ejemplo1(): Unit ={
   // val date= new Date(1232545L) //dependiendo de lo que enviemos en el date coge el de util o el de sql
    //el programa asume cual le sirve entonces podemos en los imports añadir un nombre para udentificarlo

    //asi arreglamos los conflictos entre clases
    val date= new DateUtil()
    val date2= new SqlDate(System.currentTimeMillis())

    println(date)
    println(date2)
  }
}
