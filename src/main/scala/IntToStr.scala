/**
  * Created by vans239 on 04/06/17.
  */
object IntToStr extends Checker with App {

  def intToStr(i: Int): String = {
    val sb = new StringBuilder

    var curr = i
    while(curr != 0) {
      sb.append(math.abs(curr % 10))
      curr /= 10
    }

    if (i < 0) {
      sb.append('-')
    } else if (i == 0) {
      sb.append('0')
    }
    sb.reverse.toString()
  }

  shouldEqual(intToStr(1), "1")
  shouldEqual(intToStr(-1), "-1")
  shouldEqual(intToStr(-123456), "-123456")
  shouldEqual(intToStr(123456), "123456")
  shouldEqual(intToStr(Int.MinValue), Int.MinValue.toString)
  shouldEqual(intToStr(0), "0")

  def strToInt(str: String): Int = {
    var i = 0
    var curr = 0
    var multiplier = 1

    if (str.charAt(0) == '-') {
      multiplier = -1
      i += 1
    }

    while (i < str.length) {
      curr = curr * 10 + str.charAt(i).-('0')
      i += 1
    }
    curr * multiplier
  }

  shouldEqual(strToInt("1"), 1)
  shouldEqual(strToInt("0"), 0)
  shouldEqual(strToInt("-1"), -1)
  shouldEqual(strToInt("-1234567"), -1234567)
  shouldEqual(strToInt("1234567"), 1234567)
}
