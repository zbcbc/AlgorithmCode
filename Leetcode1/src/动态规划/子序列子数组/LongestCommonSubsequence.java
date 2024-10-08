package 动态规划.子序列子数组;

/**
 * ClassName: LongestCommonSubsequence
 * Package: 动态规划.子序列
 * Description:  最长公共子序列
 *
 * @Author zbc
 * @Create 2024/9/27 上午9:41
 * @Version 1.0
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        // dp[i][j] s1中0...i内 s2中0...j内 的最长公共子序列 长度
        int n = s1.length;
        int m = s2.length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            if(s1[i] == s2[0]){
                dp[i][0] = 1;
            }else {
                if (i > 0){
                    dp[i][0] = dp[i - 1][0];
                }
            }
        }

        for (int j = 0; j < m; j++) {
            if(s1[0] == s2[j]){
                dp[0][j] = 1;
            }else {
                if (j > 0){
                    dp[0][j] = dp[0][j - 1];
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(s1[i] == s2[j]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}
