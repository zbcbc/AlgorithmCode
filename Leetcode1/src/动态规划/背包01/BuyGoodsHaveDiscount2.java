package 动态规划.背包01;

import java.io.*;
import java.util.Arrays;

/**
 * ClassName: BuyGoodsHaveDiscount2
 * Package: 动态规划.背包01
 * Description:
 *
 * @Author zbc
 * @Create 2024/9/12 上午9:51
 * @Version 1.0
 */
public class BuyGoodsHaveDiscount2 {
    public static int n, x, a, b, happy;
    public static int MAXN = 501;
    public static int MAXX = 100001;
    public static int[] weight = new int[MAXN];
    public static long[] value = new long[MAXN];
    public static int m;
    public static long[] dp = new long[MAXX];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        while (in.nextToken() != StreamTokenizer.TT_EOF){
            long ans = 0;
            m = 0;
            n = (int) in.nval;
            in.nextToken();
            x = (int) in.nval;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                a = (int) in.nval;
                in.nextToken();
                b = (int) in.nval;
                in.nextToken();
                happy = (int) in.nval;
                int curweight = 2 * b - a;
                if (curweight <= 0){
                    ans += happy;
                    x += -curweight;
                }else{
                    weight[m] = curweight;
                    value[m++] = happy;
                }
            }
            ans += compute01();
            out.println(ans);
        }
        out.flush();
        br.close();
        out.close();
    }

    public static long compute01(){
        Arrays.fill(dp, 0, x + 1, 0);
        for (int i = 0; i < m; i++) {
            for (int j = x; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        return dp[x];
    }
}
