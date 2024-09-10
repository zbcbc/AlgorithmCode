package 动态规划.一维dp;

/**
 * ClassName: maxSumOfThreeSubarrays
 * Package: 动态规划.一维dp
 * Description:
 *
 * @Author zbc
 * @Create 2024/9/4 上午10:23
 * @Version 1.0
 */
public class MaxSumOfThreeSubarrays {
    /**
     * 求三个不重叠长为k的子数组，累加和最大
     * 思路： 枚举中间长为k的子数组的位置，剩余两个子数组在该数组的前后
     * sums[i] 以i开头，长为k的子数组的累加和
     * prefix[i] 0~i范围上，长为k且拥有最大累加和的子数组的开头位置
     * suffix[i] i~n-1范围上，长为k且拥有最大累加和的子数组的开头位置
      */
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        // sums[i]
        int[] sums = new int[n];
        // 维护一个长度为k的窗口，sum记录该窗口内的累加和
        for (int l = 0, r = 0, sum = 0; r < n; r++) {
            sum += nums[r];
            if(r - l + 1 == k) {
                sums[l] = sum;
                sum -= nums[l];
                l++;
            }
        }

        // prefix[i] 0...i范围上，长为k，拥有最大累加和的子数组的开头位置
        int[] prefix = new int[n];
        // 维护一个长度为k的窗口，l从1开始，prefix[0]的子数组开头位置一定为0
        for (int l = 1, r = k; r < n; l++, r++){
            prefix[r] = sums[l] > sums[prefix[r - 1]] ? l : prefix[r - 1];
        }

        // suffix[i] i..n-1范围上，长为k，拥有最大累加和的子数组的开头位置
        int[] suffix = new int[n];
        suffix[n - k] = n - k;
        for(int l = n - k - 1; l >= 0; l--){
            suffix[l] = sums[l] >= sums[suffix[l + 1]] ? l : suffix[l + 1];
        }

        int a = 0, b = 0, c = 0, max = 0;
        // 枚举中间数组位置 维护i...j 长为k的窗口
        //  0...i-1       i...j       j+1...n-1
        // prefix[i-1]      i         suffix[j+1]
        for(int i = k, j = 2 * k - 1, p, s, curSum; j < n - k; i++, j++){
            p = prefix[i -1];
            s = suffix[j + 1];
            curSum = sums[p] + sums[i] + sums[s];
            if(curSum > max){
                max = curSum;
                a = p;
                b = i;
                c = s;
            }
        }
        return new int[]{a, b, c};
    }
}
