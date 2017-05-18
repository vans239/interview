/**
  * 5/16/17.
  *
  * @author evanslov
  */
object Quicksort extends App with Checker {
  def doPartition(array: Array[Int], start: Int, to: Int): Int = {
    val pivot = array(start)
    println(s"Pivot $pivot")
    println(s"Partition b ${array.toSeq}")
    swap(array, start, to - 1)
    var i = start
    start.until(to - 1).foreach { j =>
      if (array(j) < pivot) {
        swap(array, i, j)
        i += 1
      }
    }
    swap(array, i, to - 1)
    println(s"Partition ${array.toSeq}")

    i
  }

  def partition(array: Array[Int]): Int = doPartition(array, 0, array.length)

  def doQuicksort(array: Array[Int], start: Int, to: Int): Unit = {
    if (start < to - 1) {
      val i = doPartition(array, start, to)
      doQuicksort(array, start, i)
      doQuicksort(array, i + 1, to)
    }
  }

  def quicksort(array: Array[Int]): Unit = doQuicksort(array, 0, array.length)

  def validatePartition(): Unit = {
    0.until(10000).foreach { _ =>
      val arr = generate(15)
      val i = partition(arr)
      println(arr.toSeq)
      println(i)

      if (i > 1 && i < arr.length)
        require(arr.take(i - 1).max < arr.drop(i).min)
    }
  }

  validatePartition()

  validateSort { arr =>
    quicksort(arr)
    arr
  }
}
