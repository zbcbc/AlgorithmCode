package 动态规划.背包01;

import java.util.Arrays;

/**
 * ClassName: PartitionEqualSum
 * Package: 动态规划.背包01
 * Description:
 *
 * @Author zbc
 * @Create 2024/9/19 上午10:01
 * @Version 1.0
 */
public class PartitionEqualSum {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 == 1) return false;
        return compute(nums, sum / 2);
    }
    public boolean compute(int[] nums, int target){
        // dp[i][j] 前i个数中，目标和为j的子序列是否存在
        // dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i]]
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = dp[j] | dp[j - nums[i]];
            }
            if(dp[target] == true) return true;
        }
        return dp[target];
    }
}
