package hackerrank

import java.util.Scanner

/**
  * Created by KatKat on 20/05/17.
  */
object CustomerCenter {
  case class CallPart(timestamp: Long, isEnd: Boolean)

  def main(args: Array[String]) {
    val scanner = new Scanner(System.in)
    val currentExecutives = scanner.nextInt
    val lines = scanner.nextInt()

    def readCall(): Seq[CallPart] = {
      Seq(CallPart(scanner.nextLong, isEnd = false), CallPart(scanner.nextLong, isEnd = true))
    }

    val ordering = Ordering.by[CallPart, (Long, Boolean)] { c => (c.timestamp, !c.isEnd) }
    val callParts = 0.until(lines).flatMap(_ => readCall()).sorted(ordering).toArray
    var maxNeeded = 0
    var currNeeded = 0

    callParts.foreach {
      cp =>
        if (cp.isEnd) {
          currNeeded -= 1
        } else {
          currNeeded += 1
        }
        maxNeeded = math.max(currNeeded, maxNeeded)
    }
    println(math.max(maxNeeded - currentExecutives, 0))
  }
}
