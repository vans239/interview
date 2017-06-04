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
}
