package noesis.adapter

import noesis.model.*
import noesis.core.{Command, CoreEngine, EngineResult, Save, ShowAll}

import scala.io.StdIn.readLine

class UserRepl {
  def run(): Unit = {
    var continue = true
    var universe = Universe()

    println("🧠 Welcome to Noesis REPL. Type 'exit' to quit.\n")

    while (continue) {
      print("noesis> ")
      val input = readLine().trim

      CommandParser.parse(input) match {
        case Right(cmd) =>
          val result = CoreEngine.handle(universe, cmd)

          result match {
            case EngineResult.Changed(newUni) =>
              universe = newUni
              println(s"✅ Command accepted: $cmd")

            case EngineResult.NoChange =>
              println(s"⚠️ Nothing changed.")
          }

          cmd match {
            case ShowAll =>
              val lines =
                (universe.foundations.map("🔹 " + _.toString) ++
                  universe.theorems.map("🔸 " + _.toString)).toList.sorted
              if (lines.isEmpty) println("🕳 Nothing yet.")
              else println(lines.mkString("\n"))

            case Save =>
              println("💾 Saving not implemented yet.")

            case _ => ()
          }

        case Left("EXIT") =>
          println("👋 Goodbye.")
          continue = false

        case Left(errMsg) =>
          println(errMsg)
      }
    }
  }
}
