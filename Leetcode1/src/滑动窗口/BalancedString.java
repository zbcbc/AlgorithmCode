package 滑动窗口;

/**
 * ClassName: BalancedString
 * Package: 滑动窗口
 * Description:
 * https://leetcode.cn/problems/replace-the-substring-for-balanced-string/
 *
 * @Author zbc
 * @Create 2024/6/29 9:58
 * @Version 1.0
 */
public class BalancedString {
    public int balancedString(String s) {
        int[] cnts = new int[4];
        int[] arr = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            arr[i] = c == 'W' ? 1 : (c == 'E' ? 2 : (c == 'R' ? 3 : 0));
            cnts[arr[i]]++;
        }

        int require = s.length() / 4;

        if(check(cnts, require)){
            return 0;
        }

        int ans = s.length();
        for(int l = 0, r = 0; r < arr.length; r++){
            cnts[arr[r]]--;
            while(check(cnts, require))  {
                ans = Math.min(ans, r - l + 1);
                cnts[arr[l++]]++;
            }
        }
        return ans;
    }

    public boolean check(int[] cnts, int require){
        for(int i = 0; i < 4; i++){
            if(cnts[i] > require){
                return false;
            }

        }
        return true;
    }
}
