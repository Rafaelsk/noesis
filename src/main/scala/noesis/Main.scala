package noesis

import noesis.adapter.UserRepl

object Main {
  def main(args: Array[String]): Unit = {
    new UserRepl().run()
  }
}
