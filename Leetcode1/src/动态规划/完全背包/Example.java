package 动态规划.完全背包;

import java.io.*;

public class Example {
    public static int w, n;
    public static int[] weight;
    public static int[] value;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF){
            w = (int) in.nval;
            in.nextToken();
            n = (int) in.nval;
            weight = new int[n];
            value = new int[n];
            for (int i = 0; i < n; i++) {
                in.nextToken();
                weight[i] = (int) in.nval;
                in.nextToken();
                value[i] = (int) in.nval;
            }
            out.println(compute2());
        }
        out.flush();
        br.close();
        out.close();
    }

    /**
     * 二维dp dp[i][j] 0...i内物品，背包重量为j，可以获得的最大价值
     * @return
     */
    public static long compute1(){
        long[][] dp = new long[n][w + 1];
        //dp[...][0] = 0
        //dp[0][...]
        for (int j = weight[0]; j <= w; j++) {
            dp[0][j] = value[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= w; j++){
                dp[i][j] = j < weight[i] ? dp[i - 1][j] : Math.max(dp[i - 1][j], dp[i][j - weight[i]] + value[i]);
            }
        }
        return dp[n - 1][w];
    }

    /**
     * dp[j] 背包重量为j，可以获得的最大价值
     * @return
     */
    public static long compute2(){
        long[] dp = new long[w + 1];
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = weight[i]; j <= w; j++) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        return dp[w];
    }
}
