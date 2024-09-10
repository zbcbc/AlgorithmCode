package 动态规划.一维dp;

/**
 * ClassName: IntegerBreak
 * Package: 动态规划.一维dp
 * Description:
 *
 * @Author zbc
 * @Create 2024/8/28 上午9:26
 * @Version 1.0
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;

        for(int i = 3; i <= n; i++){
            for(int j = 1; j <= n/2; j++){
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

}
