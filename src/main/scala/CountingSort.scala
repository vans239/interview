import java.util

/**
  * Created by KatKat on 19/05/17.
  */
object CountingSort extends App with Checker {

  def countingSort(array: Array[Int]): Array[Int] = {
    require(array.forall(_ >= 0))
    val counter = new Array[Int](array.max + 1)
    array.foreach(i => counter(i) += 1)

    val res = new Array[Int](array.length)
    var j = 0
    counter.indices.foreach { i =>
      util.Arrays.fill(res, j, j + counter(i), i)
      j += counter(i)
    }
    res
  }

  validateSort(countingSort)
}
