package 动态规划.一维dp;

import java.util.Arrays;

/**
 * ClassName: MaxEnvelopes
 * Package: 动态规划.一维dp
 * Description:
 * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
 *
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 注意：不允许旋转信封。
 *
 * @Author zbc
 * @Create 2024/9/9 下午7:59
 * @Version 1.0
 */
public class MaxEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length == 0) return 0;
        int n = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> a[0] != b[0] ? (a[0] - b[0]) : (b[1] - a[1]));

        int[] minends = new int[n + 1];
        int len = 1;
        minends[1] = envelopes[0][1];

        for (int i = 1; i < n; i++) {
            int num = envelopes[i][1];
            if(num > minends[len]){
                minends[++len] = num;
            }else{
                int l = 1, r = len, k = 0, mid;
                while(l <= r){
                    mid = l + (r - l) / 2;
                    if(minends[mid] >= num){
                        k = mid;
                        r = mid - 1;
                    }else{
                        r = mid + 1;
                    }
                }
                minends[k] = num;
            }
        }
        return len;
    }
}
