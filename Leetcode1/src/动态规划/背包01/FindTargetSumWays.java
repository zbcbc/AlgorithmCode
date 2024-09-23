package 动态规划.背包01;

import java.util.Arrays;

/**
 * ClassName: FindTargetSumWays
 * Package: 动态规划.背包01
 * Description:
 *
 * @Author zbc
 * @Create 2024/9/13 上午10:40
 * @Version 1.0
 */
public class FindTargetSumWays {
    public int findTargetSumWays(int[] nums, int target){
        int sum = Arrays.stream(nums).sum();
        if((sum + target) % 2 == 1 || sum < target){
            return 0;
        }
        int t = (sum + target) / 2;
        // dp[j] 目标和为j的组合数
        int[] dp = new int[t + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++){
            for(int j = t; j >= nums[i]; j--){
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[t];
    }
}
