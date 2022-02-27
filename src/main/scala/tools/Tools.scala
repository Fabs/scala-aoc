package tools

import scala.io.Source

object Tools {
  val base = "/Users/fabun/scala/scala-aoc/src/main/scala/"
  def fileLines(src: String): Array[String] = {
    val file = Source.fromFile(s"$base/$src")
    val lines = file.getLines().toArray

    file.close()

    lines
  }
}
