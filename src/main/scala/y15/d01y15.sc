import tools.Tools.fileLines

val sample = fileLines("y15/sample.txt")
val problem = fileLines("y15/problem.txt")

def star(steps: Array[Char], start: Int): Array[(Int,Int)] = {
  steps.scanLeft(start)((acc, c) => {
    c match {
      case '(' => acc + 1
      case ')' => acc - 1
    }
  }).zipWithIndex
}

// Star 1
sample.map(s => star(s.toCharArray, 0).last._1).foreach(println _)
problem.map(s => star(s.toCharArray, 0).last._1).foreach(println _)

// Star 1
problem.map(s => star(s.toCharArray, 0).filter(_._1 == -1).map(_._2))
