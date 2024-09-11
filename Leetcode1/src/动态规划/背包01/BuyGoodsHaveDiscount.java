package 动态规划.背包01;

import java.io.*;
import java.util.Arrays;

/**
 * ClassName: BuyGoodsHaveDiscount
 * Package: 动态规划.背包01
 * Description:
 *
 * @Author zbc
 * @Create 2024/9/11 上午10:47
 * @Version 1.0
 */
public class BuyGoodsHaveDiscount {
    public static int n, x, pre, now, happy, curWeight;
    public static int MAXN = 501, MAXX = 10001;
    // 只把 需要考虑的商品 放入数组
    public static int[] weight = new int[MAXN];
    public static long[] value = new long[MAXN];
    public static int m;
    public static long[] dp = new long[MAXX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(System.out);

        while (in.nextToken() != StreamTokenizer.TT_EOF){
            long ans = 0;
            m = 0;//放入数组的下标
            n = (int) in.nval;
            in.nextToken();
            x = (int) in.nval;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                pre = (int) in.nval;
                in.nextToken();
                now = (int) in.nval;
                in.nextToken();
                happy = (int) in.nval;
                // 当前重量是负的，一定要买，并且要增加背包总重量
                curWeight = now - (pre - now);
                if(curWeight <= 0){
                    ans += happy;
                    x += -(curWeight);
                }else{
                    weight[m] = curWeight;
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
    // 在value[] weight[]数组进行01背包问题，背包重量为x
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
