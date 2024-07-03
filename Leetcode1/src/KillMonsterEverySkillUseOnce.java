/**
 * ClassName: KillMonsterEverySkillUseOnce
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author zbc
 * @Create 2024/6/6 16:07
 * @Version 1.0
 */

import java.io.*;

/**
 * 3    T = 3
 * 3 100  n = 3, m = 100
 * 10 20   A = 10, x = 20
 * 45 89
 * 5 40
 * 3 100 n = 3, m = 100
 * 10 20
 * 45 90
 * 5 40
 * 3 100 n = 3, m = 100
 * 10 20
 * 45 84
 * 5 40
 */
public class KillMonsterEverySkillUseOnce {
    public static int[] kill = new int[11];
    public static int[] blood = new int[11];

    public static boolean[] used;

    public static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while(in.nextToken() != StreamTokenizer.TT_EOF){
            int t = (int) in.nval;
            for (int i = 0; i < t; i++) {
                in.nextToken();
                int n = (int) in.nval;
                in.nextToken();
                int m = (int) in.nval;

                used = new boolean[n];
                ans = Integer.MAX_VALUE;
                for(int j = 0; j < n; j++){
                    in.nextToken();
                    kill[j] = (int) in.nval;
                    in.nextToken();
                    blood[j] = (int) in.nval;
                }
                dfs(n, 0, m);
                out.println(ans == Integer.MAX_VALUE ? -1 : ans);
            }
        }
        out.flush();
        br.close();
        out.close();
    }

    /**
     *
     * @param n n个技能
     * @param step
     * @param m 血量
     * @return
     */
    public static void dfs(int n, int step, int m){
        if(m <= 0){
            ans = Math.min(ans, step);
            return ;
        }

        for(int i = 0; i < n; i++){
            if(!used[i]){
                used[i] = true;
                int remain = m <= blood[i]? m - 2 * kill[i] : m - kill[i];
                dfs(n, step + 1, remain);
                used[i] = false;
            }
        }
    }
}
