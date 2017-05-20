package hackerrank

import java.util.Scanner

/**
  * Created by KatKat on 20/05/17.
  */
object DeltaEncoding {
  def main(args: Array[String]) {
    val scanner = new Scanner(System.in)

    if (scanner.hasNext) {
      var curr = scanner.nextInt()
      print(s"$curr ")
      while (scanner.hasNext()) {
        val next = scanner.nextInt()
        val delta = next - curr
        if (delta >= -127 && delta <= 127) {
          print(s"$delta ")
        } else {
          print(s"-128 $delta ")
        }
        curr = next
      }
    }

  }
}
