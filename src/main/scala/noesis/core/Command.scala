package noesis.core

import noesis.model.Statement

sealed trait Command
case class AddFoundation(statement: Statement) extends Command
case class ProposeStatement(statement: Statement) extends Command
case object ShowAll extends Command
case object Save extends Command

