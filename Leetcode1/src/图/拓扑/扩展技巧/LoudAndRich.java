package 图.拓扑.扩展技巧;

import java.util.ArrayList;

/**
 * ClassName: LoudAndRich
 * Package: 图.拓扑.扩展技巧
 * Description:
 *
 * @Author zbc
 * @Create 2024/7/30 上午9:59
 * @Version 1.0
 */
public class LoudAndRich {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegrees = new int[n];
        for (int[] arr : richer) {
            graph.get(arr[0]).add(arr[1]);
            indegrees[arr[1]]++;
        }

        int[] ans = new int[n];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = i;
        }

        int[] queue = new int[n];
        int l = 0, r = 0;
        for (int i = 0; i < indegrees.length; i++) {
            if(indegrees[i] == 0){
                queue[r++] = i;
            }
        }

        while (l < r) {
            int cur = queue[l++];
            for (Integer to : graph.get(cur)) {
                ans[to] = quiet[ans[cur]] < quiet[ans[to]] ? ans[cur] : ans[to];
                if(--indegrees[to] == 0){
                    queue[r++] = to;
                }
            }
        }
        return ans;
    }
}
