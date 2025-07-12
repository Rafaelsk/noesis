package noesis.core

import noesis.model._
import noesis.logic.UniverseOps
import noesis.core.EngineResult

object CoreEngine {

  def handle(universe: Universe, command: Command): EngineResult = command match {
    case AddFoundation(statement) =>
      if (UniverseOps.knows(universe, statement))
        EngineResult.NoChange
      else
        EngineResult.Changed(UniverseOps.withFoundation(universe, statement))

    case ProposeStatement(statement) =>
      if (UniverseOps.knows(universe, statement))
        EngineResult.NoChange
      else
        EngineResult.Changed(UniverseOps.withTheorem(universe, statement))

    case ShowAll | Save =>
      EngineResult.NoChange
  }
}
