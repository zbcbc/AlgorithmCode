package 图.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: AllPaths
 * Package: 图.DFS
 * Description:
 *
 * @Author zbc
 * @Create 2024/8/6 下午2:43
 * @Version 1.0
 */
public class AllPaths {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int n;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        n = graph.length;
        path.add(0);
        dfs(graph, 0);
        return ans;
    }
    public void dfs(int[][] graph, int node) {
        if(node == n - 1){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int next : graph[node]) {
            path.add(next);
            dfs(graph, next);
            path.remove(path.size() - 1);
        }
    }
}
