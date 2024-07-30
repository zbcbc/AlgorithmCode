package 图.拓扑.扩展技巧;

import java.io.*;
import java.util.ArrayList;

/**
 * ClassName: FoodLines
 * Package: 图.拓扑.扩展技巧
 * Description:
 *
 * @Author zbc
 * @Create 2024/7/29 下午2:49
 * @Version 1.0
 */
public class FoodLines {
    public static int n, m;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static int[] indegrees;
    public static int[] lines;
    public static int[] queue;
    public static int l, r;
    public static int MOD = 80112002;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        while(in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int) in.nval;
            in.nextToken();
            m = (int) in.nval;
            graph = new ArrayList<>(); //重新优化
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }
            indegrees = new int[n + 1];
            lines = new int[n + 1];
            queue = new int[n + 1];

            for (int i = 0, from, to; i < m; i++) {
                in.nextToken();
                from = (int) in.nval;
                in.nextToken();
                to = (int) in.nval;
                graph.get(from).add(to);
                indegrees[to]++;
            }

            out.println(topoSort());
        }

        out.flush();
        br.close();
        out.close();
    }

    public static int topoSort() {
        l = r = 0;
        for(int i = 1; i < indegrees.length; i++) {
            if(indegrees[i] == 0) {
                lines[i] = 1;
                queue[r++] = i;
            }
        }
        int ans = 0;
        while(l < r) {
            int cur = queue[l++];

            if(graph.get(cur).isEmpty()){
                ans = (ans + lines[cur]) % MOD;
            }else {
                for (Integer to : graph.get(cur)) {
                    lines[to] = (lines[to] + lines[cur]) % MOD;
                    if (--indegrees[to] == 0) {
                        queue[r++] = to;
                    }
                }
            }
        }
        return ans % MOD;
    }

}
