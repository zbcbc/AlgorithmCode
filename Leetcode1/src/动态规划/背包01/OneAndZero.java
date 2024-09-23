package 动态规划.背包01;

/**
 * ClassName: OneAndZero
 * Package: 动态规划.背包01
 * Description:
 *
 * @Author zbc
 * @Create 2024/9/18 上午10:13
 * @Version 1.0
 */
public class OneAndZero {
    public static int[][] dp;
    public static int findMaxForm(String[] strs, int m, int n) {
        dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int zero = 0;
            int one = 0;
            for (char c : str.toCharArray()) {
                if(c == '0'){
                    zero++;
                }else {
                    one++;
                }
            }
            // 倒序遍历
            for (int i = m; i >= zero; i--) {
                for (int j = n; j >= one; j--){
                    dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
