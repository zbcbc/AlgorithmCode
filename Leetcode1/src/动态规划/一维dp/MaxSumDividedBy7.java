package 动态规划.一维dp;

import java.util.Arrays;

/**
 * ClassName: MaxSumDividedBy7
 * Package: 动态规划.一维dp
 * Description:
 *
 * @Author zbc
 * @Create 2024/9/2 下午6:01
 * @Version 1.0
 */
public class MaxSumDividedBy7 {

    // 暴力方法
    // 为了验证
    public static int maxSum1(int[] nums) {
        // nums形成的所有子序列的累加和都求出来
        // 其中%7==0的那些累加和中，返回最大的
        // 就是如下f函数的功能
        return f(nums, 0, 0);
    }

    public static int f(int[] nums, int i, int s) {
        if (i == nums.length) {
            return s % 7 == 0 ? s : 0;
        }
        return Math.max(f(nums, i + 1, s), f(nums, i + 1, s + nums[i]));
    }

    // 正式方法
    // 时间复杂度O(n)
    public static int maxSum2(int[] nums) {
        int n = nums.length;
        //dp[i][j] 前i个数 0...i-1 累加和除以7余数为j的子序列的最大累加和
        int[][] dp = new int[n + 1][7];
        dp[0][0] = 0;
        Arrays.fill(dp[0], 1, 7, -1);
        for (int i = 1, x, cur, need; i <= n ; i++) {
            x = nums[i - 1];
            cur = nums[i - 1] % 7;
            for(int j = 0; j < 7; j++){
                dp[i][j] = dp[i - 1][j];
                need =  cur <= j ? j - cur : 7 - cur + j;
                if(dp[i - 1][need] != -1){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][need] + x);
                }
            }
        }
        return dp[n][0];
    }

    // 为了测试
    // 生成随机数组
    public static int[] randomArray(int n, int v) {
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = (int) (Math.random() * v);
        }
        return ans;
    }

    // 为了测试
    // 对数器
    public static void main(String[] args) {
        int n = 15;
        int v = 30;
        int testTime = 20000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int len = (int) (Math.random() * n) + 1;
            int[] nums = randomArray(len, v);
            int ans1 = maxSum1(nums);
            int ans2 = maxSum2(nums);
            if (ans1 != ans2) {
                System.out.println("出错了!");
            }
        }
        System.out.println("测试结束");
    }
}
