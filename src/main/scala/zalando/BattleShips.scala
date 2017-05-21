package zalando

import scala.collection.immutable

/**
  * Created by KatKat on 21/05/17.
  */
object BattleShips extends App {
  def shouldEqual[A](actual: A, expected: A): Unit = {
    if (actual != expected) {
      println(s"Expected [$expected], but [$actual]")
      assert(false)
    }
  }

  case class Point(row: Int, column: Int)

  case class Ship(topLeft: Point, bottomRight: Point) {
    def cells: Seq[Point] = for {
      column <- topLeft.column.to(bottomRight.column)
      row <- topLeft.row.to(bottomRight.row)
    } yield Point(row, column)
  }

  //todo there are unknown correctness problems in this code
  def solution(n: Int, s: String, t: String): String = {
    def parsePoint(str: String) = Point(str.charAt(0).asDigit, str.charAt(1).toInt - 'A'.toInt + 1)

    def parseShip(str: String) = {
      val Array(topLeftStr, bottomRightStr) = str.split(' ')
      Ship(parsePoint(topLeftStr), parsePoint(bottomRightStr))
    }

    def parseShips(shipsStr: String) = shipsStr.split(',').map(parseShip)

    def parseHits(hitsStr: String) = hitsStr.split(' ').map(parsePoint)

    def isSunk(s: Ship, hits: Set[Point]): Boolean = s.cells.forall(hits.contains)

    def isOnlyHit(s: Ship, hits: Set[Point]): Boolean =
      s.cells.exists(hits.contains) && s.cells.exists(!hits.contains(_))

    val ships = parseShips(s)
    val hits = parseHits(t).toSet

    val sunk = ships.count(isSunk(_, hits))
    val hit = ships.count(isOnlyHit(_, hits))

    s"$sunk,$hit"
  }

  shouldEqual(solution(4, "1B 2C,2D 4D", "2B 2D 3D 4D 4A"), "1,1")
  shouldEqual(solution(3, "1A 1B,2C 2C", "1B"), "0,1")
  shouldEqual(solution(12, "1A 2A,12A 12A", "12A"), "1,0")
  shouldEqual(solution(5, "1B 1B", "1B"), "1,0")
  shouldEqual(solution(5, "1A 2C", "1A 1B 1C 2A 2B 2C"), "1,0")
  shouldEqual(solution(5, "1A 2C,3C 3C", "1A 1B 1C 2A 2B"), "0,1")

  shouldEqual(solution(4, "1B 2C,2D 4D", "2B 2D 3D 4D 4A"), "1,1")
  shouldEqual(solution(10, "1A 2B,5D 7D", "1A 2A 2B 4D 1B"), "1,0")
  shouldEqual(solution(10, "1A 2B,5D 7D", "3A 7C 2E 4D 8C"), "0,0")

}
