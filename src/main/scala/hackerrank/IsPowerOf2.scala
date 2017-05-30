package hackerrank

/**
  * Created by vans239 on 30/05/17.
  */
object IsPowerOf2 extends App {
  def fastIsPowerOf2(arr: Array[Int]): Array[Int] = {
    arr.map { i =>
      if (fastIsPower(i)) 1 else 0
    }
  }

  def isPowerOf2(arr: Array[Int]): Array[Int] = {
    arr.map { i =>
      if (isPower(i)) 1 else 0
    }
  }

  def isPower(i: Int): Boolean = {
    if (i == 0) {
      false
    } else if (i == 1) {
      true
    } else if (i % 2 == 0) {
      isPower(i / 2)
    } else {
      false
    }
  }

  def fastIsPower(i: Int): Boolean = ((i & (i - 1)) == 0) && i != 0

  println(isPower(0))

  1.to(100).foreach {
    i =>
      println(s"$i ${isPower(i)}")
  }
}
