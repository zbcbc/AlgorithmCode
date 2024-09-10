package 动态规划.一维dp;

import java.util.Arrays;

/**
 * ClassName: MagicScrollProbelm
 * Package: 动态规划.一维dp
 * Description:
 *
 * @Author zbc
 * @Create 2024/9/3 上午10:30
 * @Version 1.0
 */
public class MagicScrollProbelm {
    public static int maxSum1(int[] nums) {
        int p1 = 0;
        for (int num : nums) {
            p1 += num;
        }
        int n = nums.length;
        int p2 = mustOneScroll(nums, 0, n - 1);
        int p3 = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            p3 = Math.max(p3, mustOneScroll(nums, 0, i - 1) + mustOneScroll(nums, i, n - 1));
        }
        return Math.max(p1, Math.max(p2, p3));
    }

    // 暴力方法
    // 为了测试
    // nums[l...r]范围上一定要用一次卷轴情况下的最大累加和
    public static int mustOneScroll(int[] nums, int l, int r) {
        int ans = Integer.MIN_VALUE;
        // l...r范围上包含a...b范围
        // 如果a...b范围上的数字都变成0
        // 返回剩下数字的累加和
        // 所以枚举所有可能的a...b范围
        // 相当暴力，但是正确
        for (int a = l; a <= r; a++) {
            for (int b = a; b <= r; b++) {
                // l...a...b...r
                int curAns = 0;
                for (int i = l; i < a; i++) {
                    curAns += nums[i];
                }
                for (int i = b + 1; i <= r; i++) {
                    curAns += nums[i];
                }
                ans = Math.max(ans, curAns);
            }
        }
        return ans;
    }

    // 正式方法
    // 时间复杂度O(n)
    public static int maxSum2(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        // 分三种情况：不使用卷轴、使用一次卷轴、使用两次卷轴
        int p1 = 0, p2 = 0, p3 = 0;
        p1 = Arrays.stream(nums).sum();

        // 使用1次卷轴 dp1[i]: 下标0...i的数组，必须使用一次卷轴的最大累加和; maxPrefix: 0...i-1所有前缀和的最大值
        // dp1[i] = Math.max(dp[i - 1] + nums[i], maxPrefix)  卷轴不影响i / 影响i
        int[] dp1 = new int[n];
        dp1[0] = 0;
        // 每一步的前缀和
        int sum = nums[0];
        int maxPrefix = Math.max(0, nums[0]); //初始化不能为nums[0] 要算上空数组时的情况为0
        for(int i = 1; i < n; i++){
            dp1[i] = Math.max(dp1[i - 1] + nums[i], maxPrefix);
            sum += nums[i];
            maxPrefix = Math.max(maxPrefix, sum);
        }
        p2 = dp1[n - 1];

        // 使用两次卷轴 已经算出在0...i使用一次，反过来再计算i...n-1上使用一次, 从右往左算
        int[] dp2 = new int[n];
        dp2[n - 1] = 0;
        sum = nums[n - 1];
        maxPrefix = Math.max(0, nums[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            dp2[i] = Math.max(dp2[i + 1] + nums[i], maxPrefix);
            sum += nums[i];
            maxPrefix = Math.max(maxPrefix, sum);
        }
        // 枚举所有的划分点
        for (int i = 1; i < n; i++) {
            // 0 ~ i-1 左
            // i ~ n-1 右
            p3 = Math.max(p3, dp1[i - 1] + dp2[i]);
        }
        return Math.max(p1, Math.max(p2, p3));

    }

    // 为了测试
    public static int[] randomArray(int n, int v) {
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = (int) (Math.random() * (v * 2 + 1)) - v;
        }
        return ans;
    }

    // 为了测试
    public static void main(String[] args) {
        int n = 50;
        int v = 100;
        int testTime = 10000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int len = (int) (Math.random() * n);
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
