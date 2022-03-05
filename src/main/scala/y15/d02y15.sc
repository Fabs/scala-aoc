import tools.Tools.fileLines

val year = 15
val day = 2
val sample = fileLines(s"y$year/d0${day}y$year.sam")
val problem = fileLines(s"y$year/d0${day}y$year.prb")

class Box(l: Int, w: Int, h: Int) {
  def wrap(): Int = {
    3*l*w + 2*w*h + 2*h*l
  }

  def ribbon(): Int = {
    2*l + 2*w + l*w*h
  }

  override def toString = s"${l}x${w}x${h} ${this.wrap()} ${this.ribbon()}"
}

def sortedBox(c1: Int, c2: Int, c3: Int): Box = {
  if (c1 <= c2) {
    if (c2 <= c3) {
      Box(c1, c2, c3)
    } else if (c3 <= c1) {
      Box(c3, c1, c2)
    } else {
      Box(c1, c3, c2)
    }
  } else {
    //c2,c1
    if (c3 <= c2) {
      Box(c3, c2, c1)
    } else if (c3 >= c1) {
      Box(c2, c1, c3)
    } else {
      Box(c2, c3, c1)
    }
  }
}

def problemInput(lines: Array[String]): Array[Box] = {
  lines.map(l => (l, l.split("x").map(_.toInt).toList))
    .map((struct: (String, List[Int])) => struct._2 match {
      case (c1: Int) :: (c2: Int) :: (c3: Int) :: Nil => sortedBox(c1, c2, c3)
      case _ => throw Error(s"Incorrect parse ${struct._1}")
    })
}

def solve(lines: Array[String]): Unit = {
  val boxes = problemInput(lines)

  val ribbon = boxes.foldLeft(0)((acc, v) => acc + v.ribbon())
  val wrap = boxes.foldLeft(0)((acc, v) => acc + v.wrap())
  println(s"wrap: $wrap ribbon: $ribbon")
  println("boxes")
  boxes.foreach(println _)
}

solve(sample)
solve(problem)
