//import scala.concurrent.ExecutionContext.Implicits.global
import java.util.concurrent.Executors
import scala.concurrent.{ExecutionContext, ExecutionContextExecutor, Future}
import scala.io.StdIn.readLine
import scala.util.{Failure, Success}

object PpalFutureEjemplo {
  //simulando una piscina de hilos
  implicit val ec: ExecutionContextExecutor = ExecutionContext.fromExecutor(Executors.newFixedThreadPool(3)) //maximo 3 hilos de los 12 procesos que puedo hacer
  //esto es para el ejemplo 7
  //otro es usar directamente el global de la linea 1 y asi usar todos los procesos

  val cpus: Int = Runtime.getRuntime.availableProcessors()

  def main(args: Array[String]): Unit = {

    println(cpus) //al tener 12 cps tengo 12 procesos que se pueden iniciar 12 procesos de manera paralela, si yo intentara ejecutar mas en el ejemplo 7
    /*println("Ejecución 1:")
    ejemplo1()

    println("Ejecución 2:") //se imprime primero esto que el futuro por los hilos
    readLine() //para esperar al hilo del future*/

    //-------------------------------
    /*println("Ejecución 1:")
    ejemplo2()

    println("Ejecución 2:") //se imprime primero esto que el futuro por los hilos
    readLine() //para esperar al hilo del future*/

    //-------------------------------
    /*println("Ejecución 1:")
    ejemplo3()

    println("Ejecución 2:") //se imprime primero esto que el futuro por los hilos
    readLine() //para esperar al hilo del future*/

    //-------------------------------
    /*println("Ejecución 1:")
    ejemplo4()

    println("Ejecución 2:") //se imprime primero esto que el futuro por los hilos
    readLine() //para esperar al hilo del future*/

    //-------------------------------
    /*println("Ejecución 1:")
    ejemplo5()

    println("Ejecución 2:") //se imprime primero esto que el futuro por los hilos
    readLine() //para esperar al hilo del future*/

    //-------------------------------
    /*println("Ejecución 1:")
    ejemplo6()

    println("Ejecución 2:") //se imprime primero esto que el futuro por los hilos
    readLine() //para esperar al hilo del future*/

    //-------------------------------
    println("Ejecución 1:")
    ejemplo7()

    println("Ejecución 2:") //se imprime primero esto que el futuro por los hilos
    readLine() //para esperar al hilo del future
  }

  //forma basica de declarar un futuro
  def ejemplo1(): Unit = {
    //esto sería otro hilo
    Future {
      println("Se ejecutó el future")
    } // pasamos el contexto de ejecucion con el implicit global pero no es recomendado
  }

  def ejemplo2(): Unit = {
    val futuro = Future {
      2 + 4
    }

    val nuevoFuturo = futuro.map(valor => valor + 1)

    nuevoFuturo.onComplete {
      case Success(value) => println(value)
      case Failure(exception) => println(exception.getMessage)
    }
  }

  //simular un retardo en la ejecución. Sleep
  def ejemplo3(): Future[Int] = Future {
    println("Empezó procesamiento del futuro")
    Thread.sleep(1000)
    println("Termino procesamiento del futuro")
    1
  }

  //muchos futuros
  def ejemplo4(): Unit = {
    //los procesos no terminan en el mismo orden que se escribieron en código

    Future {
      println("Empezó procesamiento del futuro 1")
      Thread.sleep(1000)
      println("Termino procesamiento del futuro 1")
      1
    }

    Future {
      println("Empezó procesamiento del futuro 2")
      Thread.sleep(1000)
      println("Termino procesamiento del futuro 2")
      1
    }

    Future {
      println("Empezó procesamiento del futuro 3")
      Thread.sleep(1000)
      println("Termino procesamiento del futuro 3")
      1
    }

    Future {
      println("Empezó procesamiento del futuro 4")
      Thread.sleep(1000)
      println("Termino procesamiento del futuro 4")
      1
    }
  }

  //sumando valores de varios futuros
  def ejemplo5(): Unit = {
    //los procesos no terminan en el mismo orden que se escribieron en código

    val f1 = Future {
      println("Empezó procesamiento del futuro 1")
      Thread.sleep(1000)
      println("Termino procesamiento del futuro 1")
      1
    }

    val f2 = Future {
      println("Empezó procesamiento del futuro 2")
      Thread.sleep(1000)
      println("Termino procesamiento del futuro 2")
      1
    }

    val f3 = Future {
      println("Empezó procesamiento del futuro 3")
      Thread.sleep(1000)
      println("Termino procesamiento del futuro 3")
      1
    }

    val f4 = Future {
      println("Empezó procesamiento del futuro 4")
      Thread.sleep(1000)
      println("Termino procesamiento del futuro 4")
      1
    }

    //val futureFinal: Future[Future[Future[Future[Int]]]] = f1.map(r1 => f2.map(r2 => f3.map(r3 => f4.map(r4 => r1 + r2 + r3 + r4))))

    //aplanando lo anterior para poder tener un futuro de tipo entero
    //la inicializacion siempre entra en orden 1, 2, 3, 4
    val futureFinal2: Future[Int] = f1.flatMap(r1 => f2.flatMap(r2 => f3.flatMap(r3 => f4.map(r4 => r1 + r2 + r3 + r4))))

    futureFinal2 onComplete {
      case Success(value) => println(value)
      case Failure(exception) => println(exception.getMessage)
    }
  }

  //ejemplo reglas negocio
  def ejemplo6(): Unit = {
    //un futuro depende de otro futuro
    val resultadoFuturo: Future[Future[Int]] = Reglas.sumar(1, 2).map(r1 => Reglas.sumar(r1, 1).map(r2 => r2 + 1))

    resultadoFuturo onComplete {
      case Success(value) => println(value)
      case Failure(exception) => println(exception.getMessage)
    }
  }

  //no garantiza el inicio porque es de manera paralela por el for
  def ejemplo7(): Unit = {
    //los procesos no terminan en el mismo orden que se escribieron en código

    val f1 = Future {
      println("Empezó procesamiento del futuro 1")
      Thread.sleep(1000)
      println("Termino procesamiento del futuro 1")
      1
    }

    val f2 = Future {
      println("Empezó procesamiento del futuro 2")
      Thread.sleep(1000)
      println("Termino procesamiento del futuro 2")
      1
    }

    val f3 = Future {
      println("Empezó procesamiento del futuro 3")
      Thread.sleep(1000)
      println("Termino procesamiento del futuro 3")
      1
    }

    val f4 = Future {
      println("Empezó procesamiento del futuro 4")
      Thread.sleep(1000)
      println("Termino procesamiento del futuro 4")
      1
    }

    //val futureFinal: Future[Future[Future[Future[Int]]]] = f1.map(r1 => f2.map(r2 => f3.map(r3 => f4.map(r4 => r1 + r2 + r3 + r4))))

    //aplanando lo anterior para poder tener un futuro de tipo entero
    //la inicializacion siempre entra en orden 1, 2, 3, 4
    val futureFinal2: Future[Int] = for {
      r1 <- f1
      r2 <- f2
      r3 <- f3
      r4 <- f4
    } yield r1 + r2 + r3 + r4

    futureFinal2 onComplete {
      case Success(value) => println(value)
      case Failure(exception) => println(exception.getMessage)
    }
  }
}
