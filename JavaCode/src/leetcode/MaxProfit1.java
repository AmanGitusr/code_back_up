package leetcode;
    /*   https://leetcode.com/problems/best-time-to-buy-and-sell-stock/  */
public class MaxProfit1 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit: " + findMaxProfit(prices));
    }


    public static int findMaxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;

        int min = prices[0];
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            int diff = prices[i] - min;
            profit = Math.max(profit, diff);
            min = Math.min(min, prices[i]);
        }
        return profit;
    }

}
