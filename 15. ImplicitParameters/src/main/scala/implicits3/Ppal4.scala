package implicits3

class Mahadi {
  val haveCar: String = "BMW"
}

class Jhonny {
  val haveTV: String = "Sony"
}

object Ppal4 {
  //recibo mahadi pero devuelvo jhonny. Podemos entonces tener objetos con propieades que no son de él. Se hizo una conversión implicita
  implicit def z(a: Mahadi): Jhonny = new Jhonny

  def main(args: Array[String]): Unit = {
    ejemplo()
  }

  def ejemplo(): Unit = {
    val mahadi: Mahadi = new Mahadi

    mahadi.haveTV //compiler will use z here like new Jhonny().haveTv. Cuando le pase un mahadi, tratarlo como un jhonny a la hora de combinar comportamientos
    //pero es peligroso porque severa locura xd

    println(mahadi.haveTV) //result Sony & no error
  }
}
