/**
  * Created by KatKat on 19/05/17.
  */
object MergeSort extends App with Checker {

  def mergeSort(array: Array[Int]): Array[Int] = {
    def merge(a: Array[Int], b: Array[Int]): Array[Int] = {
      val tmp = new Array[Int](a.length + b.length)
      var i = 0
      var j = 0
      var k = 0
      while (i < a.length && j < b.length) {
        if (a(i) < b(j)) {
          tmp(k) = a(i)
          i += 1
        } else {
          tmp(k) = b(j)
          j += 1
        }
        k += 1
      }
      while (i < a.length) {
        tmp(k) = a(i)
        k += 1
        i += 1
      }
      while (j < b.length) {
        tmp(k) = b(j)
        k += 1
        j += 1
      }
      tmp
    }

    if (array.length > 1) {
      val middle = array.length / 2
      val a = mergeSort(array.take(middle))
      val b = mergeSort(array.drop(middle))
      merge(a, b)
    } else {
      array
    }
  }


  validateSort(mergeSort)

}
