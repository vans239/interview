import scala.annotation.tailrec

/**
  * Greatest common divisor
  * Created by KatKat on 19/05/17.
  */
object GCD extends App with Checker {

  @tailrec
  def gcd(a: Int, b: Int): Int = {
    if (a == 0 || b == 0)
      math.max(a, b)
    else
      gcd(math.max(a, b) % math.min(a, b), math.min(a,b))
  }

  def lcm(a: Int, b: Int): Int = a * b / gcd(a, b)

  shouldEqual(gcd(4, 6), 2)
  shouldEqual(gcd(4,8), 4)
  shouldEqual(lcm(4, 8), 8)
  shouldEqual(lcm(4, 6), 12)
}
