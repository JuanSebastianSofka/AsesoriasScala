package packageobject

import java.sql.Date //de aqui solo uso el date
import java.util.{Date => _, _} //del util voy a usar todo menos el date

object ppal3 {
  def main(args: Array[String]): Unit = {
    ejemplo()
  }

  def ejemplo(): Unit = {
    val date = new Date(System.currentTimeMillis())
    println(date)
  }
}
