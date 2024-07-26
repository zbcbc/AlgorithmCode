package 图.拓扑;

import java.io.*;
import java.util.ArrayList;

/**
 * ClassName: TopoSort
 * Package: 图.拓扑
 * Description:
 *
 * @Author zbc
 * @Create 2024/7/26 上午9:38
 * @Version 1.0
 */
public class TopoSortNowcoder {
    public static int n, m;
    public static int[] indegree;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static int from, to;
    public static int[] queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while(in.nextToken() != StreamTokenizer.TT_EOF){
            n = (int) in.nval;
            in.nextToken();
            m = (int) in.nval;
            indegree = new int[n + 1];

            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < m; i++) {
                in.nextToken();
                from = (int) in.nval;
                in.nextToken();
                to = (int) in.nval;
                graph.get(from).add(to);
                indegree[to]++;
            }

            int cnt = 0;
            int l = 0, r = 0;
            queue = new int[n];
            for(int i = 1; i <= n; i++){
                if(indegree[i] == 0){
                    queue[r++] = i;
                    cnt++;
                }
            }

            while(l < r){
                int cur = queue[l++];
                for (Integer to : graph.get(cur)) {
                    if(--indegree[to] == 0){
                        queue[r++] = to;
                        cnt++;
                    }
                }
            }

            if(cnt != n){
                out.println(-1);
            }else{
                for (int i = 0; i < queue.length - 1; i++) {
                    out.print(queue[i] + " ");
                }
                out.println(queue[queue.length - 1]);

            }
            out.flush();
            br.close();
            out.close();
        }
    }
}
