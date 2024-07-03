package 滑动窗口;

/**
 * ClassName: NumberOfSubstringsWithabc
 * Package: 滑动窗口
 * Description:
 *
 * @Author zbc
 * @Create 2024/7/3 10:42
 * @Version 1.0
 */
public class NumberOfSubstringsWithabc {
    public int numberOfSubstrings(String str) {
        char[] s = str.toCharArray();
        int ans = 0;
        //记录窗口内词频
        int[] cnts = new int[3];

        for(int l = 0, r = 0, collect = 0; l < s.length; l++){
            if(cnts[s[r] - 'a']++ == 0){
                collect++;
            }
            while(collect < 3 && r < s.length){
                cnts[s[r] - 'a']++;
            }

            ans += s.length - r + 1;
            cnts[s[l] - 'a']--;
        }
        return ans;
    }
}
