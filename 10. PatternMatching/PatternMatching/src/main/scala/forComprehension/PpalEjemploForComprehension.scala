package forComprehension

case class User(name: String)

object PpalEjemploForComprehension {
  def main(args: Array[String]): Unit = {
    ejemplo1()

    ejemplo2(None)

    ejemplo3()
  }

  def ejemplo1(): Unit ={
    val users: List[User] = List(User("Juan"), User("Pedro"), User("Pablo"))

    //forma 1
    val resultado = for (user <- users)
      yield user.name

    println(resultado)

    //forma con condicionales
    val resultado2 = for (user <- users if user.name == "Juan")
      yield user.name

    println(resultado2)
  }

  def ejemplo2(numero1: Option[Int]): Unit ={

    val numero2 = Option(1)
    val numero3 = Option(1)
    val numero4 = Option(1)

    //for con cuerpo
    //da error si envio none en la función dice que ya devuelve un none
    //es acepto todos los tipos validos o nada
    val suma : Option[Int] = for{
      n1 <- numero1
      n2 <- numero2
      n3 <- numero3
      n4 <- numero4
    } yield n1 + n2 + n3 + n4

    println(s"La sumatoria de los numeros es ${suma.getOrElse(0)}")
  }

  def ejemplo3(): Unit ={
    //si alguno es left revienta porque ya dejan de ser del mismo tipo
    val either1: Either[String,Int] = Right(2)
    val either2: Either[String,Int] = Right(2)
    val either3: Either[String,Int] = Right(2)
    val either4: Either[String,Int] = Right(2)

    //este for es muy usado para objetos de tipo option, either, future, etc
    val suma = for{
      n1 <- either1
      n2 <- either2
      n3 <- either3
      n4 <- either4
    } yield n1 + n2 + n3 + n4

    suma.map(x=>println(x))
  }
}
