import java.util

/**
  * Created by KatKat on 19/05/17.
  */
object NMerge extends App with Checker {

  //O(N*k)
  def nmerge(arr: Array[Array[Int]]): Array[Int] = {
    val indices = new Array[Int](arr.length)
    util.Arrays.fill(indices, 0)

    var i = 0
    val tmp = new Array[Int](arr.map(_.length).sum)
    while(i < tmp.length) {
      var minIndex = -1
      var minValue = Integer.MAX_VALUE
      arr.zipWithIndex.foreach {
        case (subarray, j) =>
          if (indices(j) < subarray.length && (minIndex == -1 || subarray(indices(j)) < minValue)) {
            minIndex = j
            minValue = arr(minIndex)(indices(minIndex))
          }
      }
      tmp(i) = minValue
      indices(minIndex) += 1
      i += 1
    }
    tmp
  }

  def nmergeHeap(arr: Array[Array[Int]]): Array[Int] = {
    implicit val ordering = Ordering.by[(Int, Int), Int](- _._1)
    val queue = new scala.collection.mutable.PriorityQueue[(Int, Int)]
    val indices = new Array[Int](arr.length)
    util.Arrays.fill(indices, 0)

    def tryPush(i: Int) = {
      val offset = indices(i)
      if (offset < arr(i).length) {
        queue.+=((arr(i)(offset), i))
        indices(i) += 1
      }
    }

    indices.indices.foreach(i => tryPush(i))

    var i = 0
    val tmp = new Array[Int](arr.map(_.length).sum)
    while (i < tmp.length) {
      val (value, index) = queue.dequeue()
      tmp(i) = value
      tryPush(index)
      i += 1
    }
    tmp
  }

  def validate(merge: Array[Array[Int]] => Array[Int]): Unit = {
    shouldEqual(merge(Array(Array(4), Array(7), Array(1, 3))).mkString(""), "1347")
  }

  validate(nmerge)
  validate(nmergeHeap)
}
