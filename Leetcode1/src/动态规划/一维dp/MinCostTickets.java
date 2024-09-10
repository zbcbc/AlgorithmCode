package 动态规划.一维dp;

import java.util.Arrays;

/**
 * ClassName: MinCostTickets
 * Package: 动态规划.一维dp
 * Description:
 *
 * @Author zbc
 * @Create 2024/8/26 下午3:12
 * @Version 1.0
 */
public class MinCostTickets {
    public static int MAXN = 366;
    // dp[i] 从第days[i]天到最后一天的最低旅行花费
    public static int[] dp = new int[MAXN];
    // 通行证天数
    public static int[] limit = {1, 7, 30};

    public static int mincostTickets(int[] days, int[] costs) {

        int n = days.length;
        // 初始化 0~n-1为max，n为0
        Arrays.fill(dp, 0, n+1, Integer.MAX_VALUE);
        dp[n] = 0;

        // 从后往前dp
        for (int i = n - 1; i >= 0; i--) {
            // 3种通行证cost[j], 计算最小花费
            // k用来计算这个通行证可以维持到下一次旅行的那一天
            for (int j = 0, k = i; j < 3; j++) {
                while(k < n && days[i] + limit[j] > days[k]){
                    k++;
                }
                dp[i] = Math.min(dp[i], costs[j] + dp[k]);
            }
        }
        return dp[0];
    }
}
