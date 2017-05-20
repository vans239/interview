package hackerrank

import java.io.{BufferedReader, InputStreamReader}

/**
  * Created by KatKat on 20/05/17.
  */
object HotelReviews {
  case class HotelReview(hotelId: Int, weight: Int)

  def clean(s: String): String = s.toLowerCase.replaceAll("[.,]", "")

  implicit val ordering = Ordering.by[HotelReview, (Int, Int)] {
    r => (-r.weight, r.hotelId)
  }

  def main(args: Array[String]): Unit = {
    val reader = new BufferedReader(new InputStreamReader(System.in))

    val words = clean(reader.readLine()).split(' ').toSet
    val numReviews = reader.readLine().toInt

    def readReview() = {
      val hotelId = reader.readLine().toInt
      val review = clean(reader.readLine())
      val weight = review.split(' ').count(words.contains)
      HotelReview(hotelId, weight)
    }

    val reviews = 0.until(numReviews).map(_ => readReview())

    val res = reviews.groupBy(r => r.hotelId).map { case (i, hotelReviews) =>
      HotelReview(i, hotelReviews.map(_.weight).sum)
    }.toSeq.sortBy {
      r =>
        (-r.weight, r.hotelId)
    }

    println(res.map(_.hotelId).mkString(" "))
  }
}

//      hotelWeightMap.put(hotelId)hotelWeightMap.getOrDefault(hotelId, 0) + weight
