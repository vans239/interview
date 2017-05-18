/**
  * 5/18/17.
  *
  * @author evanslov
  */
object KmpFind extends App with Checker {
  def prepare(template: String): Array[Int] = {
    var curr = 1
    var transi = 0
    val trans = new Array[Int](template.length)
    trans(0) = 0
    while (curr < template.length) {
      if (template(curr) == template(transi)) {
        transi += 1
      } else {
        transi = 0
      }
      trans(curr) = transi
      curr += 1
    }
    trans
  }

  def find(text: String, s: String): Int = {
    val trans = prepare(s)
    var i = 0
    var transi = 0
    while (i < s.length && transi < trans.length) {
      if (s(i) == text(i)) {
        transi += 1
      } else {
        transi = trans(transi)
      }
      i += 1
    }

    if (transi == trans.length) {
      i
    } else {
      -1
    }
  }

  printArr(prepare("zazabaza"))
  printArr(prepare("ctgcctag"))
}
