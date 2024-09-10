package 动态规划.一维dp;

import java.util.Arrays;

/**
 * ClassName: MaximinSubMatrix
 * Package: 动态规划.一维dp
 * Description:
 *
 * @Author zbc
 * @Create 2024/8/30 上午10:55
 * @Version 1.0
 */
public class MaximinSubMatrix {
    public int[] getMaxMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int max = Integer.MIN_VALUE;
        int a = 0, b = 0, c = 0, d = 0;
        int[] nums = new int[m];

        for(int up = 0; up < n; up++){
            Arrays.fill(nums, 0);

            for(int down = up; down < n; down++){
                // 转化为问题1

                for(int l = 0, r = 0, pre = Integer.MIN_VALUE; r < m; r++){
                    // 压缩
                    nums[r] += matrix[down][r];
                    if(pre < 0) {
                        pre = nums[r];
                        l = r;
                    }else{
                        pre += nums[r];
                    }
                    if(pre > max){
                        max = pre;
                        a = up;
                        b = l;
                        c = down;
                        d = r;
                    }
                }
            }
        }
        return new int[]{a, b, c, d};
    }
}
