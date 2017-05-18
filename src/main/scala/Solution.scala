import java.io._
import java.util.Scanner

import scala.util.Random

/**
  * 5/14/17.
  *
  * @author evanslov
  */
object Solution1 extends App {
  def fun(time: String): String = {
    val hours = time.substring(0, 2).toInt
    val rest = time.substring(3, 8)
    val militaryHours = (time.contains("AM"), hours) match {
      case (true, 12) => "00"
      case (true, a) => f"$a%02d"
      case (false, 12) => "12"
      case (false, a) => (a + 12).toString
    }
    println(s"$militaryHours:$rest")
    s"$militaryHours:$rest"
  }

  require(fun("07:05:45PM") == "19:05:45")
  require(fun("10:05:45PM") == "22:05:45")
  require(fun("10:05:45AM") == "10:05:45")
  require(fun("12:05:45PM") == "12:05:45")
  require(fun("12:05:45AM") == "00:05:45")
  require(fun("04:59:59AM") == "04:59:59")
}

object Solution2 extends App with Checker {

  def fun(arr: Array[Int]): Int = {
    val counters = new Array[Int](6)
    arr.foreach { i =>
      counters(i) = counters(i) + 1
    }
    val max = counters.max
    counters.indexOf(max)
  }

  shouldEqual(fun(Array(1, 4, 4, 4, 5, 3)), 4)
}

object Solution3 extends App with Checker {

  import java.math.BigInteger

  def fun(n: Int): BigInteger = {
    1.toLong.to(n.toLong).map(BigInteger.valueOf).reduce[BigInteger] {
      case (a, b) => a.multiply(b)
    }
  }

  shouldEqual(fun(25), new BigInteger("15511210043330985984000000"))
}

object Solution4 extends App with Checker {

  import java.io.{InputStream, OutputStream}

  def isValid(values: Array[Int]): Boolean = {
    val x = for {
      i <- values.indices
      j <- (i + 1).until(values.length)
      if values(i) > values(j)
    } yield 1
    x.sum % 2 == 0
  }

  override def app(in: InputStream, out: OutputStream): Unit = {
    val pw = new PrintWriter(out)
    val scanner = new java.util.Scanner(in)
    val num = scanner.nextInt()
    0.until(num).foreach { _ =>
      val c = scanner.nextInt()
      val arr = readIntArray(scanner, c)
      if (isValid(arr)) {
        pw.println("YES")
      } else {
        pw.println("NO")
      }
    }
    pw.close()
  }

  shouldEqual(test("3\n3\n3 1 2\n4\n1 3 4 2\n5\n1 2 3 5 4"), "YES\nYES\nNO\n")
}

object Solution6 extends App with Checker {
  //find-the-median

  def kth(arr: Array[Int], k: Int): Int = {
    if (arr.length == 1) {
      arr(0)
    } else {
      val base = arr(0)
      val left = arr.filter(_ < base)
      val right = arr.filter(_ > base)
      k match {
        case _ if k <= left.length =>
          kth(left, k)
        case _ if k <= arr.length - right.length =>
          base
        case _ =>
          val next = k - arr.length + right.length
          kth(right, next)
      }
    }
  }

  def sortKth(array: Array[Int], k: Int): Int = array.sorted.apply(k - 1)

  def generate(n: Int): Array[Int] = {
    val arr = new Array[Int](n)
    0.until(n).foreach(i => arr(i) = Random.nextInt(15))
    arr
  }

  def validate(): Unit = {
    0.to(1000).foreach { _ =>
      val arr = generate(7)
      println(arr.toSeq)
      shouldEqual(kth(arr, 5), sortKth(arr, 5))
    }
  }

  override def app(in: InputStream, out: OutputStream): Unit = {
    val scanner = new Scanner(in)
    val arr = readIntArray(scanner, scanner.nextInt)
    println(kth(arr, arr.length / 2 + arr.length % 2))
  }

  shouldEqual(test("7\n0 1 2 4 6 5 3"), "3")
}

object Solution7 extends App with Checker {
  def partition(arr: Array[Int]): Array[Int] = {
    val base = arr(0)
    val left = arr.filter(_ < base)
    val right = arr.filter(_ > base)
    val equals = arr.filter(_ == base)
    left ++ equals ++ right
  }

  override def app(in: InputStream, out: OutputStream): Unit = {
    val scanner = new Scanner(in)
    val arr = readIntArray(scanner, scanner.nextInt)
    val pw = new PrintWriter(out)
    pw.println(partition(arr).mkString(" "))
    pw.close()
  }

  shouldEqual(test("5\n4 5 3 7 2"), "3 2 4 5 7\n")

}

object Solution8 extends App with Checker {
  def inplacePartition(arr: Array[Int], start: Int, end: Int): Int = {

    val base = arr(end - 1)
    var i = start
    var j = i
    while (j < end - 1) {
      if (arr(j) < base) {
        swap(arr, i, j)
        i += 1
        j += 1
      } else {
        j += 1
      }
    }

    swap(arr, i, end - 1)
    println(arr.mkString(" "))
    i
  }

  def quickSort(arr: Array[Int], start: Int, end: Int): Unit = {
    if (end - start <= 1) return

    val i = inplacePartition(arr, start, end)
    quickSort(arr, start, i)
    quickSort(arr, i + 1, end)
  }

  override def app(in: InputStream, out: OutputStream): Unit = {
    val scanner = new Scanner(in)
    val arr = readIntArray(scanner, scanner.nextInt)
    val pw = new PrintWriter(out)
    quickSort(arr, 0, arr.length)
    pw.println(arr.mkString(" "))
    pw.close()
  }

  shouldEqual(test("7\n1 3 9 8 2 7 5"),
              "1 3 2 5 9 7 8\n1 2 3 5 9 7 8\n1 2 3 5 7 8 9\n")

}

object Solution9 extends App with Checker {
  def count(limit: Int, arr: Array[Int]): Array[Int] = {
    val counters = new Array[Int](limit)
    arr.foreach(i => counters(i) += 1)
    counters
  }

  override def app(in: InputStream, out: OutputStream): Unit = {
    val scanner = new Scanner(in)
    val arr = readIntArray(scanner, scanner.nextInt)
    val pw = new PrintWriter(out)
    val counters = count(100, arr)
    pw.println(counters.mkString(" "))
    pw.close()
  }

  print(test("7\n1 3 9 8 2 7 1"))
}
