package noesis.model

sealed trait Statement {
  def text: String
  override def toString: String = text
}

object Statement {
  case class Atom(text: String) extends Statement
  // We can later add more forms like Implication, Conjunction, etc.
}
