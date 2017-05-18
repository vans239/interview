import java.util

import scala.util.Random

/**
  * 5/16/17.
  *
  * @author evanslov
  */
object BinarySearch extends App with Checker {

  /**
    * index of the search key, if it is contained in the array;
    * otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.  The
    * <i>insertion point</i> is defined as the point at which the
    * key would be inserted into the array: the index of the first
    * element greater than the key, or <tt>a.length</tt> if all
    * elements in the array are less than the specified key.  Note
    * that this guarantees that the return value will be &gt;= 0 if
    * and only if the key is found.
    */
  def doBinarySearch(arr: Array[Int], el: Int, start: Int, end: Int): Int = {
    if (start > end - 1) {
      -start - 1
    } else {
      val middle = (start + end) / 2
      println(s"$start $middle $end")
      arr(middle) match {
        case x if x > el =>
          doBinarySearch(arr, el, start, middle)
        case x if x == el =>
          middle
        case x if x < el =>
          doBinarySearch(arr, el, middle + 1, end)
      }
    }
  }

  def binarySearch(arr: Array[Int], el: Int): Int =
    doBinarySearch(arr, el, 0, arr.length)

  def validate(): Unit = {
    0.until(10000).foreach { _ =>
      val arr = generate(50).distinct.array
      util.Arrays.sort(arr)
      val el = Random.nextInt(15)
      println(arr.toSeq)
      println(el)
      shouldEqual(binarySearch(arr, el), util.Arrays.binarySearch(arr, el))
    }
  }

  validate()

}
