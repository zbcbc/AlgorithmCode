package LCR;

/**
 * ClassName: LCR067
 * Package: LCR
 * Description:
 *https://leetcode.cn/problems/ms70jA/?envType=study-plan-v2&envId=coding-interviews-special
 * @Author zbc
 * @Create 2024/7/13 下午12:30
 * @Version 1.0
 */
public class LCR067 {
    public int MAXN = 2000000;
    public int[][] tree = new int[MAXN][2];
    public int cnt;
    public int high;

    public int findMaximumXOR(int[] nums) {
        build(nums);
        int ans = 0;
        for(int num : nums){
            ans = Math.max(ans, maxXor(num));
        }
        return ans;
    }

    public void build(int[] nums){
        cnt = 1;
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            max = Math.max(max, num);
        }
        high = 31 - Integer.numberOfLeadingZeros(max);

        for(int num : nums){
            int cur = 1;
            for(int i = high, want, path; i >= 0; i--){
                path = (num >> i) & 1;
                if(tree[cur][path] == 0){
                    tree[cur][path] = ++cnt;
                }
                cur = tree[cur][path];
            }
        }
    }

    public int maxXor(int num){
        int ans = 0, cur = 1;
        for(int i = high, want, path; i >= 0; i--){
            path = (num >> i) & 1;
            want = path ^ 1;
            if(tree[cur][want] == 0){
                want ^= 1;
            }
            ans |= (path ^ want) << i;
            cur = tree[cur][want];
        }
        return ans;
    }
}
