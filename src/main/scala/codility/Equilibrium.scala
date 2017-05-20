package codility

/**
  * Created by KatKat on 20/05/17.
  */
import scala.collection.JavaConverters._

//Find an index in an array such that its prefix sum equals its suffix sum.
object Equilibrium {
  def solution(a: Array[Int]): Int = {
    val total = a.map(_.toLong).sum
    var curr = 0l
    var i = 0
    var found = false
    while (i < a.length && !found) {
      if (curr == total - curr - a(i)) {
        found = true
      }
      curr += a(i)
      i += 1
    }
    if (found) i - 1 else -1
    // write your code in Scala 2.12
  }
}
