package leetcode;
        /*  https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/   */
public class MaxProfit2 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 4, 5};
        System.out.println("Max Profit: " + findMaxProfit(prices));
    }


    public static int findMaxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;

        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i+1])
                profit += prices[i+1] - prices[i];
        }
        return profit;
    }
}
