package noesis.adapter

import upickle.default._
import java.nio.file.{Files, Paths}
import java.nio.charset.StandardCharsets

case class Metadata(
                     name: String,
                     author: String,
                     created_at: String,
                     description: String = ""
                   )

case class Universe(
                     metadata: Metadata,
                     foundations: Seq[String],
                     theorems: Seq[String]
                   )

object UniverseIO {

  given ReadWriter[Metadata] = macroRW
  given ReadWriter[Universe] = macroRW

  def loadFromFile(path: String): Universe = {
    val content = Files.readString(Paths.get(path), StandardCharsets.UTF_8)
    read[Universe](content)
  }

  def saveToFile(universe: Universe, path: String): Unit = {
    val json = write(universe, indent = 2)
    Files.write(Paths.get(path), json.getBytes(StandardCharsets.UTF_8))
  }
}
