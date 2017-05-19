
/**
  * Created by KatKat on 19/05/17.
  */
object RabinKarpSearch extends App with Checker {

  def find(text: String, template: String): Int = {

    val base = 0.until(template.length).foldLeft(1) { case (acc, _) => acc * 31}

    def hashStr(str: String) = {
      var curr = 0
      str.foreach {
        c =>
          curr = curr * 31 + c.toInt
      }
      curr
    }

    def doFind() = {
      val templateHash = hashStr(template)

      var i = template.length
      var textHash = hashStr(text.substring(0, i))
      var foundIndex = -1
      while (i <= text.length && foundIndex == -1) {
        val firstIndex = i - template.length
        if (textHash == templateHash && text.substring(firstIndex, firstIndex + template.length) == template) {
          foundIndex = firstIndex
        }
        if (i != text.length)
          textHash = textHash * 31 - text(firstIndex) * base + text(i)
        i += 1
      }

      foundIndex
    }

    if (text.length < template.length) -1 else doFind()
  }

  shouldEqual(find("ab", "b"), 1)
  shouldEqual(find("b", "ab"), -1)
  shouldEqual(find("ctgcctag", "ctg"), 0)
  shouldEqual(find("ctgcctag", "ctga"), -1)
  shouldEqual(find("abcdabcabcdabcdab", "cabcdabcdab"), 6)

}
