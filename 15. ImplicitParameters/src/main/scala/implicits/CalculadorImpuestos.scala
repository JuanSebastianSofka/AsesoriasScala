package implicits

trait CalculadorImpuestos {
  def calcularIva(valor: Double)(implicit iva: Double) = valor * iva
}

object CalculadorImpuestos extends CalculadorImpuestos
