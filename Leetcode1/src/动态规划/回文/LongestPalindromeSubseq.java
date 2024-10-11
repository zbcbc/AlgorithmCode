package 动态规划.回文;

/**
 * ClassName: LongestPalindromeSubseq
 * Package: 动态规划.回文
 * Description:
 *
 * @Author zbc
 * @Create 2024/10/11 上午11:08
 * @Version 1.0
 */
public class LongestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if(s.charAt(i) == s.charAt(j)){
                    if(j - i <= 1){
                        dp[i][j] = j - i + 1;
                    }else{
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }
                }else{
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][len - 1];
    }
}
