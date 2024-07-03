import java.util.HashSet;

/**
 * ClassName: TwoNumbersMaximumXor2
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author zbc
 * @Create 2024/6/13 20:10
 * @Version 1.0
 */
public class TwoNumbersMaximumXor2 {
    public static int findMaximumXOR(int[] nums){
        int ans = 0;
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            max = Math.max(max, num);
        }
        int high = 31 - Integer.numberOfLeadingZeros(max);

        HashSet<Integer> set = new HashSet<>();
        //从最高位high开始，挨个找ans的最佳结果
        //ans: high ... i+1 位 已经达成的最好结果
        for(int i = high; i >= 0; i--){
            //现在找第i位的最好结果，使用两数之和做法
            set.clear();
            int better = ans | (1 << i);
            for(int num : nums){
                //将num的第0到i-1位置为0,为了和better对齐
                num = (num >> i) << i;
                set.add(num);
                //两数之和做法，num ^ num' = better，则 num' = num ^ better
                if(set.contains(better ^ num)){
                    ans = better;
                    break;
                }
            }
        }
        return ans;
    }
}
