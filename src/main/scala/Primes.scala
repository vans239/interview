/**
  * Created by KatKat on 19/05/17.
  */
object Primes extends App with Checker {

  def primes(maxValue: Int): Iterator[Int] = {
    def primeChilds(i: Int) = Iterator.from(i, i).takeWhile(_ < maxValue)

    def doPrimes(from: Int, notPrimes: Set[Int]): Iterator[Int] = {
      val prime = Iterator.from(from).filter(!notPrimes.contains(_)).next()
      Iterator(prime) ++ doPrimes(prime + 1, notPrimes ++ primeChilds(prime))
    }

    doPrimes(2, Set.empty)
  }

  shouldEqual(primes(100).take(5).toList, List(2, 3, 5, 7, 11))
}
