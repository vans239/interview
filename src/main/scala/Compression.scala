/**
  * Created by vans239 on 04/06/17.
  */
object Compression extends Checker with App {

  def compress(s: String): String = {
    val sb = new StringBuilder
    var cnt = 0
    var char: Character = null

    def tryPrintCurrent = if (char != null && cnt != 0) {
      sb.append(cnt).append(char)
    }

    for(c <- s) {
      if (c != char) {
        tryPrintCurrent
        char = c
        cnt = 0
      }
      cnt += 1
    }
    tryPrintCurrent
    sb.toString()
  }

  shouldEqual(compress(""), "")
  shouldEqual(compress("abba"), "1a2b1a")
}
