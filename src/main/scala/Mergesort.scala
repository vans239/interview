import java.util

/**
  * 5/16/17.
  *
  * @author evanslov
  */
object Mergesort extends App with Checker {
  class Heap {
    private var arr = new util.ArrayList[Int]()

    import scala.collection.JavaConverters._

    def print: Unit = println(arr.asScala.mkString(","))

    def push(i: Int): Unit = {
      arr.add(i)
      relax(arr.size() - 1)
    }

    private def swap(i: Int, j: Int) = {
      val tmp = arr.get(i)
      arr.set(i, arr.get(j))
      arr.set(j, tmp)
    }

    private def relax(index: Int): Unit = {
      val parent = getParent(index)
      if (arr.get(index) > arr.get(parent)) {
        swap(index, parent)
        if (parent != 0) relax(parent)
      }
    }

    def peek(): Int = arr.get(0)

    def pop(): Int = pop(0)

    private def pop(index: Int): Int = {
      val c = arr.get(index)
      arr.set(index, arr.get(arr.size() - 1))
      arr.remove(arr.size() - 1)
      backrelax(index)
      c
    }

    private def getParent(i: Int) = (i - 1) / 2

    private def getLeft(i: Int) = 2 * i + 1

    private def getRight(i: Int) = 2 * i + 2

    private def backrelax(index: Int): Unit = {
      val left = getLeft(index)
      val right = getRight(index)
      val maxChild =
        if (right < arr.size() && arr.get(right) > arr.get(left)) {
          Some(right)
        } else if (left < arr.size()) {
          Some(left)
        } else
          None
      maxChild match {
        case Some(e) if arr.get(index) < arr.get(e) =>
          swap(index, e)
          backrelax(e)
        case _ =>
      }
    }
  }

  def heapsort(array: Array[Int]): Array[Int] = {
    val heap = new Heap
    array.foreach { i =>
      heap.push(i)
    }
    (array.length - 1).to(0, -1).foreach { i =>
      array(i) = heap.pop()
    }

    array
  }

  validateSort(heapsort)

}

//0 -> 1 2
//1 -> 3 4
//2 -> 5 6
//3 -> 7 8
