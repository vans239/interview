package hackerrank

/**
  * Created by vans239 on 30/05/17.
  */
object MatrixSummation extends App {
  def shouldEqual[A](actual: A, expected: A): Unit = {
    if (actual != expected) {
      println(s"Expected [$expected], but [$actual]")
      assert(false)
    }
  }

  def findMatrix(after: Array[Array[Int]]): Array[Array[Int]] = {
    val width = after(0).length
    val height = after.length
    val before = new Array[Array[Int]](height)
    before.indices.foreach { i => before(i) = new Array[Int](width)}

    def safeValue(i: Int, j: Int) = if (i < 0 || j < 0) 0 else after(i)(j)

    0.until(height).foreach {
      i =>
        0.until(width).foreach {
          j =>
            before(i)(j) = safeValue(i, j) - safeValue(i - 1, j) - safeValue(i, j - 1) + safeValue(i - 1, j - 1)
        }
    }
    before
  }

  def asListers(arr: Array[Array[Int]]) = arr.map(_.toList).toList

  println(asListers(findMatrix(Array(Array(1,2), Array(3, 4)))))
  shouldEqual(asListers(findMatrix(Array(Array(1,2), Array(3, 4)))), asListers(Array(Array(1, 1), Array(2, 0))))
  shouldEqual(asListers(findMatrix(Array(Array(2, 1), Array(5, 4)))), asListers(Array(Array(2, -1), Array(3, 0))))

  shouldEqual(asListers(findMatrix(Array(Array(1, 2)))), asListers(Array(Array(1, 1))))
}
