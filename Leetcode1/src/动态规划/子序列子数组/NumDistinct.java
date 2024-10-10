package 动态规划.子序列子数组;

/**
 * ClassName: NumDistinct
 * Package: 动态规划.子序列子数组
 * Description:
 *
 * @Author zbc
 * @Create 2024/10/8 下午7:43
 * @Version 1.0
 */
public class NumDistinct {
    public int numDistinct(String str, String tar) {
        // 在s的子序列中t出现的个数
        // dp[i][j] 在s[0...i - 1]的子序列中，t 以j - 1结尾的子序列 出现的个数
        // if(s[i] == t[j]) dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]
        // else dp[i][j] = dp[i - 1][j]
        char[] s = str.toCharArray();
        char[] t = tar.toCharArray();
        int len1 = s.length;
        int len2 = t.length;
        if(len1 < len2) return 0;

        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = 1;
        }
        //dp[0][j] = 1;

        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                if (s[i] == t[j]){
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[len1][len2];
    }
}
