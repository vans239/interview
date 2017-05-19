import java.util
import scala.collection.JavaConverters._
/**
  * Created by KatKat on 19/05/17.
  */
object RadixSort extends App with Checker {

  def radixSort(array: Array[Int]): Array[Int] = {
    val bucketsNum = 10

    def doRadixSort(array: Array[Int], base: Int): Array[Int] = {
      val buckets = new Array[java.util.ArrayList[Int]](bucketsNum)
      buckets.indices.foreach { i => buckets(i) = new util.ArrayList[Int]() }
      array.foreach {
        el =>
          val num = (el / base) % bucketsNum
          buckets(num).add(el)
      }
      buckets.flatMap(_.asScala)
    }

    var maxIterations = 5
    var base = 1
    var tmp = array
    while(maxIterations > 0) {
      tmp = doRadixSort(tmp, base)
      maxIterations -= 1
      base *= 10
    }
    tmp
  }

  validateSort(radixSort)
}
