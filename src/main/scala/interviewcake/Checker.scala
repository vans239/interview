package interviewcake

import scala.util.Random

/**
  * 5/16/17.
  *
  * @author evanslov
  */
trait Checker {

  import java.io._

  def shouldEqual[A](actual: A, expected: A): Unit = {
    if (actual != expected) {
      println(s"Expected [$expected], but [$actual]")
      assert(false)
    }
  }

  def readIntArray(scanner: java.util.Scanner, n: Int): Array[Int] = {
    val values = new Array[Int](n)
    0.until(n).foreach(i => values(i) = scanner.nextInt())
    values
  }

  def app(in: InputStream, out: OutputStream): Unit = {}

  def run(): Unit = app(System.in, System.out)

  def test(input: String): String = {
    val out = new ByteArrayOutputStream()
    app(new ByteArrayInputStream(input.getBytes), out)
    out.toString
  }

  def generate(n: Int, maxValue: Int = 1000): Array[Int] = {
    val arr = new Array[Int](n)
    0.until(n).foreach(i => arr(i) = Random.nextInt(maxValue))
    arr
  }

  def swap(arr: Array[Int], i: Int, j: Int): Unit = {
    val tmp = arr(i)
    arr(i) = arr(j)
    arr(j) = tmp
  }

  def validateSort(f: Array[Int] => Array[Int]): Unit = {
    0.until(10000).foreach { _ =>
      val arr = generate(7)
      val arr2 = arr.toList.sorted.toArray
      shouldEqual(f(arr).toSeq, arr2.toSeq)
    }
  }

  def printArr(array: Array[Int]): Unit =
    println(array.mkString(", "))
}
