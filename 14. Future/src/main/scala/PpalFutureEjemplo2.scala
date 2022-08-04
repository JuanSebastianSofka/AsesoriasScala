
import java.util.concurrent.Executors
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext, ExecutionContextExecutor, Future}
import scala.io.StdIn.readLine
import scala.util.{Failure, Success}

object PpalFutureEjemplo2 {

  implicit val ec: ExecutionContextExecutor = ExecutionContext.fromExecutor(Executors.newFixedThreadPool(3))
  val cpus: Int = Runtime.getRuntime.availableProcessors()

  def main(args: Array[String]): Unit = {
    //ejemplo8()
    //ejemplo9()
    //ejemplo10()
    ejemplo11()
  }

  //algo que nos encontraremos en el día a día
  def ejemplo8(): Unit = {

    val lista: List[Int] = List.range(1, 10)

    val resultado: List[Future[Int]] = lista.map(Reglas.sumar(_))

    val resultado2: Future[List[Int]] = Future.sequence(resultado) //el hace la magia para sumar, lo cambio de lista de futuros a un futuro de lista

    val future: Future[Int] = resultado2.map(_.sum)

    //de forma academica para obtener un valor, pero no se debe hacer
    val valor = Await.result(future, Duration.Inf) //espera de manera infinita, pero esto no se usa o no es recomendado, con esto volvemos una
    // app asincrona a sincrona

    println("future " + future)
    println("valor " + valor)

    //otra forma de sumar sin sequence pero mas compleja
    val resultadoSinSequencia: Future[Int] = resultado.foldLeft(Future(0))((r, f) => r.flatMap(v => f.map(v2 => v + v2)))
  }

  //tratar los errores
  def ejemplo9(): Unit = {
    val futuro = Reglas.sumar(2).map(r => r / 0)

    futuro onComplete {
      case Success(value) => println(value)
      case Failure(ex) => println("error " + ex.getMessage)
    }
  }

  //evitar el failure y recuperarse usando recover
  def ejemplo10(): Unit = {
    val futuro = Reglas.sumar(2).map(r => r / 0).recover(error => {
      println("error 1 " + error.getMessage)
      0
    })

    futuro onComplete {
      case Success(value) => println(value)
      case Failure(ex) => println("error 2 " + ex.getMessage)
    }
  }

  //sumar option
  def ejemplo11(): Unit = {
    val resultadoOpt: Option[Future[Int]] = Some(Reglas.sumar(1))

    val future: Future[Option[Int]] = Future.sequence(resultadoOpt.toIterable).map(_.headOption)

    val futuro2sinOption: Future[Int] = future.map(_.getOrElse(0))

    futuro2sinOption onComplete {
      case Success(value) => println(value)
      case Failure(ex) => println("error 2 " + ex.getMessage)
    }
  }
}
