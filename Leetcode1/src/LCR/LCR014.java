package LCR;

/**
 * ClassName: CheckInclusion
 * Package: 滑动窗口
 * Description: https://leetcode.cn/problems/MPnaiL/?envType=study-plan-v2&envId=coding-interviews-special
 *
 * @Author zbc
 * @Create 2024/7/8 上午10:19
 * @Version 1.0
 */
public class LCR014 {
    public boolean checkInclusion(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int len1 = s1.length;
        //s1中的字符
        int[] cnt1 = new int[26];
        //窗口中的字符
        int[] cnt2 = new int[26];

        int need = 0;
        for(char ch : s1){
            if(cnt1[ch - 'a']++ == 0){
                need++;
            }
        }
        int collect = 0;
        //先维护一个l = 0, r = len1 -1, 即长度为len1的窗口 再去滑动
        for(int r = 0; r < len1; r++){
            if(++cnt2[s2[r] - 'a'] == cnt1[s2[r] - 'a']){
                collect++;
            }
        }
        if(need == collect) {
            return true;
        }

        //滑动
        for(int l = 0, r = len1; r < s2.length; l++, r++){
            if(cnt2[s2[l] - 'a']-- == cnt1[s2[l] - 'a']){
                collect--;
            }
            if(++cnt2[s2[r] - 'a'] == cnt1[s2[r] - 'a']){
                collect++;
            }
            if(collect == need){
                return true;
            }
        }
        return false;

    }
}
