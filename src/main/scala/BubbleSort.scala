/**
  * Created by vans239 on 23/06/17.
  */
object BubbleSort extends App with Checker {

  def sort(array: Array[Int]): Array[Int] = {
    array.indices.foreach {
      i =>
        0.until(array.length - i - 1).foreach {
          j =>
            if (array(j) > array(j + 1)) {
              val tmp = array(j + 1)
              array(j + 1) = array(j)
              array(j) = tmp
            }
        }
    }
    array
  }

  validateSort(sort)
}
