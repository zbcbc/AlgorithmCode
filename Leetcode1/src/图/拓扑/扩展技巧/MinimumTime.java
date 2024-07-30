package 图.拓扑.扩展技巧;

import java.util.ArrayList;

/**
 * ClassName: MinimumTime
 * Package: 图.拓扑.扩展技巧
 * Description:
 *
 * @Author zbc
 * @Create 2024/7/30 上午10:58
 * @Version 1.0
 */
public class MinimumTime {
    public int minimumTime(int n, int[][] relations, int[] time) {
        int[] cost = new int[n + 1];
        int[] indegrees = new int[n + 1];
        int[] queue = new int[n + 1];
        int l = 0 ,r = 0;
        ArrayList<ArrayList<Integer>> graph= new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] relation : relations) {
            graph.get(relation[0]).add(relation[1]);
            indegrees[relation[1]]++;
        }
        int ans = 0;
        for (int i = 1; i < indegrees.length; i++) {
            if(indegrees[i] == 0){
                queue[r++] = i;
                cost[i] = time[i - 1];
                ans = Math.max(ans, cost[i]);
            }
        }

        while (l < r){
            int cur = queue[l++];
            for (Integer next : graph.get(cur)) {
                cost[next] = Math.max(cost[next], cost[cur] + time[next - 1]);
                ans = Math.max(ans, cost[next]);
                if(--indegrees[next] == 0){
                    queue[r++] = next;
                }
            }
        }
        return ans;
    }
}
