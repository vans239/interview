import java.io.{InputStream, OutputStream, PrintWriter}
import java.util.Scanner

/**
  * 5/16/17.
  *
  * @author evanslov
  */
object Kth extends App with Checker {
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
    val pw = new PrintWriter(out)
    pw.println(kth(arr, arr.length / 2 + arr.length % 2))
    pw.close()
  }

  validate()
  shouldEqual(test("7\n0 1 2 4 6 5 3"), "3\n")
}
