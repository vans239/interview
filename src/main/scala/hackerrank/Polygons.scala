package hackerrank

import java.util.Scanner

/**
  * Created by KatKat on 20/05/17.
  */
//Polygons
object Polygons {
  def main(args: Array[String]) {
    val scanner = new Scanner(System.in)

    var squares = 0
    var rectangles = 0
    var other = 0

    while(scanner.hasNext) {
      val a = scanner.nextInt()
      val b = scanner.nextInt()
      val c = scanner.nextInt()
      val d = scanner.nextInt()
      if (a <= 0 || b <= 0 || c <= 0 || d <= 0) {
        other += 1
      } else if (a == b && b == c && c == d) {
        squares += 1
      } else if (a == c && b == d) {
        rectangles += 1
      } else {
        other += 1
      }
    }
    println(s"$squares $rectangles $other")
    //Enter your code here. Read input from STDIN. Print output to STDOUT
  }
}
