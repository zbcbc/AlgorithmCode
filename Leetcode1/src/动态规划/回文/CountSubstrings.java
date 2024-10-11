package 动态规划.回文;

/**
 * ClassName: CountSubstrings
 * Package: 动态规划.回文
 * Description:
 *
 * @Author zbc
 * @Create 2024/10/11 上午10:12
 * @Version 1.0
 */
public class CountSubstrings {
    public int countSubstrings(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int ans = 0;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if(s.charAt(i) == s.charAt(j)){
                    if(j - i <= 1){
                        dp[i][j] = true;
                        ans++;
                    }else if(dp[i + 1][j - 1]){
                        dp[i][j] = true;
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
