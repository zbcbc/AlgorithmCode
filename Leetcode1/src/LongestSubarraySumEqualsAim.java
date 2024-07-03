import java.io.*;
import java.util.HashMap;

/**
 * ClassName: LongestSubarraySumEqualsAim
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author zbc
 * @Create 2024/6/15 9:50
 * @Version 1.0
 */
public class LongestSubarraySumEqualsAim {
    public static int N;
    public static int k;
    public static int MAXN = 100002;
    public static int[] arr = new int[MAXN];
    /**
     * key: 某个前缀和
     * value: 该前缀和出现的最早位置
     * 下标为i时的前缀和为sum 即0~i的和为sum，目标为aim，那么只要找前缀和为（sum - aim)出现的最早位置，就是i向左累加和为aim的最长情况
     */
    public static HashMap<Integer, Integer> map = new HashMap<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        while (in.nextToken() != StreamTokenizer.TT_EOF){
            N = (int) in.nval;
            in.nextToken();
            k = (int) in.nval;
            for(int i = 0; i < N; i++){
                in.nextToken();
                arr[i] = (int) in.nval;
            }
            out.println(compute());
        }
        out.flush();
        br.close();
        out.close();
    }

    public static int compute(){
        map.clear();
        // 重要 : 0这个前缀和，一个数字也没有的时候，就存在了
        map.put(0, -1);
        int ans = 0;
        for(int i = 0, sum = 0; i < N; i++){
            sum += arr[i];
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
            if(map.containsKey(sum - k)){
                ans = Math.max(ans, i - map.get(sum - k));
            }
        }
        return ans;
    }
}
