package leetcode;
    /*  https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/  */
public class MaxProfit3 {
    public static void main(String[] args) {
        int[] arr = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println("Max profit: " + findMaxProfit(arr));
    }
    public static int findMaxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;

        int fb = Integer.MIN_VALUE, sb = Integer.MIN_VALUE;
        int fs = 0, ss = 0;

        for (int i = 0; i < prices.length; i++) {
            fb = Math.max(fb, -prices[i]);
            fs = Math.max(fs, fb + prices[i]);
            sb = Math.max(sb, fs - prices[i]);
            ss = Math.max(ss, sb + prices[i]);
        }
        return ss;
    }
}
