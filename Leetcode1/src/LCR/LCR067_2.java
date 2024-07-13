package LCR;

import java.util.HashSet;

/**
 * ClassName: LCR067_2
 * Package: LCR
 * Description:
 *
 * @Author zbc
 * @Create 2024/7/13 下午1:08
 * @Version 1.0
 */
public class LCR067_2 {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        for(int num : nums){
            max = Math.max(max, num);
        }
        int high = 31 - Integer.numberOfLeadingZeros(max);

        HashSet<Integer> set = new HashSet<>();

        int ans = 0;
        for(int i = high, better; i >= 0; i--){
            set.clear();
            better = ans | (1 << i);
            for(int num : nums){
                num = (num >> i) << i;
                set.add(num);

                if(set.contains(better ^ num)){
                    ans = better;
                    break;
                }
            }
        }
        return ans;
    }
}
