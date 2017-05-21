package zalando

/**
  * Created by KatKat on 21/05/17.
  */
import scala.annotation.tailrec
import scala.collection.JavaConverters._

object Elevator extends App {
  def shouldEqual[A](actual: A, expected: A): Unit = {
    if (actual != expected) {
      println(s"Expected [$expected], but [$actual]")
      assert(false)
    }
  }

  @tailrec
  def doSolution(accumulator: Int, weights: Seq[Int], targets: Seq[Int], maxCapacity: Int, maxWeight: Int): Int = {
    if (weights.isEmpty) {
      accumulator
    } else {
      //todo in worst case it is O(n^2) (maxCapacity: 1, maxWeight: Infinity)
      val canTakeWeight =
        weights.view
          .scanLeft(0) { case (curr, weight) => curr + weight}
          .zipWithIndex
          .takeWhile { case (total, _ ) => total <= maxWeight}
          .last._2
      val canTakeCapacity = maxCapacity
      val willBeProcessed = math.min(canTakeCapacity, canTakeWeight)

      val floorVisits = targets.take(willBeProcessed).toSet.size + 1
      doSolution(
        accumulator + floorVisits,
        weights.drop(willBeProcessed),
        targets.drop(willBeProcessed),
        maxCapacity,
        maxWeight
      )
    }
  }

  def solution(weights: Array[Int], targets: Array[Int], maxFloor: Int, maxCapacity: Int, maxWeight: Int): Int =
    doSolution(0, weights.toList, targets.toList, maxCapacity, maxWeight)

  shouldEqual(solution(Array(60, 80, 40), Array(2, 3, 5), 5, 2, 200), 5)
  shouldEqual(solution(Array(40, 40, 100, 80, 20), Array(3, 3, 2, 2, 3), 3, 5, 200), 6)
  shouldEqual(solution(Array(40, 40, 100, 80, 20), Array(3, 3, 2, 2, 3), 3, 5, 200), 6)

  shouldEqual(solution(Array(1, 2), Array(3, 3), 3, 2, 200), 2)
  shouldEqual(solution(Array(1, 2), Array(3, 3), 3, 1, 200), 4)
  shouldEqual(solution(Array(1, 2), Array(3, 3), 3, 5, 2), 4)
}
