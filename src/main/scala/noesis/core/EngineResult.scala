package noesis.core

import noesis.model.Universe

sealed trait EngineResult

object EngineResult {
  case object NoChange extends EngineResult
  case class Changed(newUniverse: Universe) extends EngineResult
}
