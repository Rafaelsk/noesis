package noesis.logic

import noesis.model.Universe
import noesis.model.Statement

object UniverseOps {

  def knows(universe: Universe, statement: Statement): Boolean =
    universe.foundations.contains(statement) || universe.theorems.contains(statement)

  def withFoundation(universe: Universe, statement: Statement): Universe =
    universe.copy(foundations = universe.foundations + statement)

  def withTheorem(universe: Universe, statement: Statement): Universe =
    universe.copy(theorems = universe.theorems + statement)

  def all(universe: Universe): Set[Statement] =
    universe.foundations ++ universe.theorems
}
