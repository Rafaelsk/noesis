package noesis.model

import noesis.model.Statement

case class Universe(
                     foundations: Set[Statement] = Set.empty,
                     theorems: Set[Statement] = Set.empty
                   )
