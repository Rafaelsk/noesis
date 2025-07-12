package noesis.adapter

import noesis.core.*
import noesis.model.*
import noesis.model.Statement.Atom


object CommandParser {

  def parse(input: String): Either[String, Command] = {
    val trimmed = input.trim

    if (trimmed.startsWith("foundation ")) {
      val stmtText = trimmed.stripPrefix("foundation ").trim
      if (stmtText.isEmpty)
        Left("❌ Missing statement for foundation.")
      else
        Right(AddFoundation(Atom(stmtText)))

    } else if (trimmed.startsWith("propose ")) {
      val stmtText = trimmed.stripPrefix("propose ").trim
      if (stmtText.isEmpty)
        Left("❌ Missing statement to propose.")
      else
        Right(ProposeStatement(Statement.Atom(stmtText)))

    } else if (trimmed == "show all") {
      Right(ShowAll)

    } else if (trimmed == "save") {
      Right(Save)

    } else if (trimmed == "exit") {
      Left("EXIT") // Special signal for REPL

    } else {
      Left(s"❓ Unknown command: '$input'")
    }
  }
}
