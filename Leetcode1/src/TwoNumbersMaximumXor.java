import java.util.Arrays;

/**
 * ClassName: TwoNumbersMaximumXor
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author zbc
 * @Create 2024/6/13 10:41
 * @Version 1.0
 */
public class TwoNumbersMaximumXor {
    public static int MAXN = 2000000;
    public static int[][] tree = new int[MAXN][2];
    public static int cnt;
    public static int high;

    public static int findMaximumXOR(int[] nums){

        build(nums);
        int ans = 0;
        for(int num : nums){
            ans = Math.max(ans, maxXOR(num));
        }
        clear();
        return ans;
    }

    public static void build(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            max = Math.max(max, num);
        }
        high = 31 - Integer.numberOfLeadingZeros(max);
        cnt = 1;
        for(int num : nums){
            insert(num);
        }
    }

    public static void insert(int num){
        int cur = 1;
        for(int i = high, path; i >= 0; i--){
            path = (num >> i) & 1;
            if(tree[cur][path] == 0){
                tree[cur][path] = ++cnt;
            }
            cur = tree[cur][path];
        }
    }

    public static void clear(){
        int cur = 1;
        for (int i = 1; i <= cnt; i++) {
            Arrays.fill(tree[i], 0);
        }
    }

    public static int maxXOR(int num){
        int ans = 0, cur = 1;
        for(int i = high, want, status; i >= 0; i--){
            status = (num >> i) & 1;
            want = status ^ 1;
            if(tree[cur][want] == 0){
                //不能达成,改回want
                want ^= 1;
            }
            ans |= (status ^ want) << i;
            cur = tree[cur][want];
        }
        return ans;
    }


}
