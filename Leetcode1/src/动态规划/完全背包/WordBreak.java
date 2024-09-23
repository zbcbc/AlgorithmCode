package 动态规划.完全背包;

import java.util.HashSet;
import java.util.List;

/**
 * ClassName: WordBreak
 * Package: 动态规划.完全背包
 * Description:
 *
 * @Author zbc
 * @Create 2024/9/23 下午2:37
 * @Version 1.0
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        //dp[j] 是否可以拼接出以第j个字母结尾的字符串
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < wordDict.size(); i++) {
                if(wordDict.get(i).length() <= j){
                    dp[j] = dp[j] | (dp[j - wordDict.get(i).length()] && set.contains(s.substring(i, j)));
                }

            }
        }
        return dp[s.length()];
    }

}
