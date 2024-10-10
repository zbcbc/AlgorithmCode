package 动态规划.编辑距离;

/**
 * ClassName: DeleteOfTwoString
 * Package: 动态规划.编辑距离
 * Description:
 *
 * @Author zbc
 * @Create 2024/10/10 上午9:35
 * @Version 1.0
 */
public class DeleteOfTwoString {
    public int minDistance(String word1, String word2) {
        char[] s = word1.toCharArray();
        char[] t = word2.toCharArray();
        int len1 = s.length;
        int len2 = t.length;
        // dp[i][j] s以i-1结尾的字符串 和 t以j-1结尾的字符串 相同所需的最小步数
        int[][] dp = new int[len1 + 1][len2 + 1];
        // 初始化
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if(s[i - 1] == t[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 2, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }
            }
        }
        return dp[len1][len2];
    }
}
