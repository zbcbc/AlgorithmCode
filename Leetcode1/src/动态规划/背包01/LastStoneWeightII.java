package 动态规划.背包01;

import java.util.Arrays;

/**
 * ClassName: LastStoneWeightII
 * Package: 动态规划.背包01
 * Description:
 *
 * @Author zbc
 * @Create 2024/9/18 下午12:00
 * @Version 1.0
 */
public class LastStoneWeightII {
    public static int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        // 在数组中找累加和<=sum/2，但又尽可能大的子序列的累加和
        int near = near(stones, sum / 2);
        return sum - near - near;
    }
    public static int near(int[] nums, int target){
        // dp[i][j] 前i个数中，累加和<=j又足够大的子序列的累加和
        // if(j >= nums[i]) dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i])
        int[] dp = new int[target + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[target];
    }
}
