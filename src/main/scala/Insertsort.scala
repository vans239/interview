/**
  * 5/17/17.
  *
  * @author evanslov
  */
object Insertsort extends App with Checker {
  def insertsort(array: Array[Int]) = {
    1.to(array.length).foreach { i =>
      var curr = i - 1
      while (curr > 0 && array(curr) < array(curr - 1)) {
        swap(array, curr, curr - 1)
        curr -= 1
      }
    }
    array
  }

  validateSort(insertsort)
}
