import scala.concurrent.{ExecutionContext, Future}

trait Reglas {
  def sumar(a: Int,b: Int)(implicit executionContext: ExecutionContext): Future[Int] = Future{
    a + b
  }

  def sumar(a: Int)(implicit executionContext: ExecutionContext): Future[Int] = Future{
    a + 1
  }
}

object Reglas extends Reglas
