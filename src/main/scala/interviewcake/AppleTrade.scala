package interviewcake

/**
  * Created by vans239 on 23/06/17.
  */
/*
Suppose we could access yesterday's stock prices as a list, where:

The indices are the time in minutes past trade opening time, which was 9:30am local time.
The values are the price in dollars of Apple stock at that time.
So if the stock cost $500 at 10:30am, stock_prices_yesterday[60] = 500.

Write an efficient function that takes stock_prices_yesterday and returns the best profit I could have made from 1 purchase and 1 sale of 1 Apple stock yesterday.
*/
object AppleTrade extends App with Checker {
  def findBestTrade(prices: Array[Int]): Int = {
    var best = Integer.MIN_VALUE
    var currMin = Integer.MAX_VALUE
    prices.foreach {
      price =>
        best = Math.max(best, price - currMin)
        currMin = Math.min(price, currMin)
    }
    best
  }

  shouldEqual(findBestTrade(Array(10, 7, 5, 8, 11, 9)), 6)
  shouldEqual(findBestTrade(Array(10, 9, 8, 7)), -1)

}
