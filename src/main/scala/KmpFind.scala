/**
  * 5/18/17.
  *
  * @author evanslov
  */
object KmpFind extends App with Checker {
  def prepare(template: String): Array[Int] = {
    val pr = new Array[Int](template.length)
    pr(0) = 0
    var k = 0
    var i = 1
    while (i < template.length) {
      if (template(i) == template(k)) {
        k += 1
        pr(i) = k
        i += 1
      } else if (k == 0) {
        pr(i) = 0
        i += 1
      } else {
        k = pr(k - 1) //todo i think that there is a bug here.
      }
    }
    pr
  }

  def find(text: String, s: String): Int = {
    val pr = prepare(s)
    var i = 0
    var k = 0
    while (k < s.length && i < text.length) {
      if (s(k) == text(i)) {
        k += 1
        i += 1
      } else if (k == 0) {
        i += 1
      } else {
        k = pr(k - 1)
      }
    }

    if (k == s.length) {
      i - s.length
    } else {
      -1
    }
  }

  shouldEqual(prepare("zazabaza").mkString(""), "00120012")
  shouldEqual(prepare("ctgcctag").mkString(""), "00011200")
  shouldEqual(prepare("abcdabcabcdabcdab").mkString(""), "00001231234567456")

  shouldEqual(find("ctgcctag", "ctg"), 0)
  shouldEqual(find("ctgcctag", "ctga"), -1)
  println(find("abcdabcabcdabcdab", "cabcdabcdab"))
  shouldEqual(find("abcdabcabcdabcdab", "cabcdabcdab"), 6)
}
