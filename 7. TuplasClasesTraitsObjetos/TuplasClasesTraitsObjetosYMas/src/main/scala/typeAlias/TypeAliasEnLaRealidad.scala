package typeAlias

import typeAlias.TypeAliasEnLaRealidad.{Usuario, id}

object TypeAliasEnLaRealidad {
  type id = String
  type Usuario = Persona
}

case class Cliente(idCliente: id)

class Persona(id: id)



trait operaciones {
  val usuario = new Usuario("2")
}
