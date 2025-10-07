public class BestTimeToBuyAndSaleStock {

  //prices = [7,1,5,3,6,4] -> 5
  public int maxProfit(int[] prices) {
    int l = 0, r = 1, maxProfit = 0;

    while (r < prices.length) {
      if (prices[l] < prices[r]) {
        maxProfit = Math.max(maxProfit, prices[r] - prices[l]);
      } else {
        l = r;
      }
      r++;
    }
    return maxProfit;
  }
}
