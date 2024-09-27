package 动态规划.子序列子数组;

/**
 * ClassName: LongestCommonArray
 * Package: 动态规划.子序列子数组
 * Description:
 *
 * @Author zbc
 * @Create 2024/9/27 上午10:16
 * @Version 1.0
 */
public class LongestCommonArray {
    public int findLength(int[] nums1, int[] nums2) {
        //dp[i][j] nums1以i结尾向左延伸、nums2以j结尾向左延伸的 最长公共子数组 的长度
        //nums[i] == nums[j], dp[i][j] = dp[i - 1][j - 1]
        // else =0
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n][m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums1[i] == nums2[0]) {
                dp[i][0] = 1;
                ans = 1;
            }
        }
        for (int j = 0; j < m; j++) {
            if (nums1[0] == nums2[j]) {
                dp[0][j] = 1;
                ans = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(nums1[i] == nums2[j]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }
}
