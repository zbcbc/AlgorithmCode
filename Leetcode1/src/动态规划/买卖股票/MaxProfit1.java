package 动态规划.买卖股票;

/**
 * ClassName: MaxProfit1
 * Package: 动态规划.买卖股票
 * Description:
 *
 * @Author zbc
 * @Create 2024/9/25 上午9:57
 * @Version 1.0
 */
public class MaxProfit1 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        //dp[i][0] 第 i 天持有股票所得最多现金
        //dp[i][1] 第 i 天不持有股票所得最多现金
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i -1][0] + prices[i]);
        }
        return dp[n - 1][1];
    }
}
