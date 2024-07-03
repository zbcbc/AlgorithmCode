/**
 * ClassName: SuperPalindrome
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author zbc
 * @Create 2024/6/11 10:27
 * @Version 1.0
 */
public class SuperPalindrome {
    public static int superpalindromesInRange(String left, String right) {
        long l = Long.valueOf(left);
        long r = Long.valueOf(right);
        long limit = (long) Math.sqrt((double) r);
        //种子 根据seed生成偶数长度/奇数长度的回文串num；判断该num的平方是否回文，如果回文即为超级回文串
        long seed = 1;

        long num = 0;
        int ans = 0;

        //限制生成奇数长度回文串后的num 小于根号r，如果限制偶数长度，会错过答案
        while(num <= limit){
            //生成偶数长度回文串 121 -> 121121
            num = evenEnlarge(seed);
            if(check(l, r, num * num)){
                ans++;
            }
            //生成奇数长度回文串 121 -> 12121
            num = oddEnlarge(seed);
            if(check(l, r, num * num)){
                ans++;
            }
            //种子+1
            seed++;
        }

        return ans;
    }

    public static long evenEnlarge(long seed){
        long ans = seed;
        while(seed != 0){
            ans = ans * 10 + seed % 10;
            seed /= 10;
        }
        return ans;
    }

    public static long oddEnlarge(long seed){
        long ans =seed;
        seed /= 10;
        while(seed != 0){
            ans = ans * 10 + seed % 10;
            seed /= 10;
        }
        return ans;
    }

    public static boolean check(long l, long r, long ans){
        return ans >= l && ans <= r && isPalindrome(ans);
    }

    public static boolean isPalindrome(long ans){
        long offset = 1;
        while(ans / offset >= 10){
            offset *= 10;
        }
        // ans = 45654 offset = 10000
        while(ans != 0){
            if(ans / offset != ans % 10){
                return false;
            }
            ans = (ans % offset) / 10;
            offset /= 100;
        }
        return true;
    }
}
