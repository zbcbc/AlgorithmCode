package 图.DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: RemoveStones1
 * Package: 图.DFS
 * Description:
 *
 * @Author zbc
 * @Create 2024/8/22 上午10:39
 * @Version 1.0
 */
public class RemoveStones1 {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        List<List<Integer>> edge = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            edge.add(new ArrayList<Integer>());
        }

        HashMap<Integer, ArrayList<Integer>> rowMap = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> colMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!rowMap.containsKey(stones[i][0])) {
                rowMap.put(stones[i][0], new ArrayList<Integer>());
            }
            //在行表中该行加入这个石头
            rowMap.get(stones[i][0]).add(i);

            if (!colMap.containsKey(stones[i][1])) {
                colMap.put(stones[i][1], new ArrayList<Integer>());
            }
            //在列表中的该列加入这个石头
            colMap.get(stones[i][1]).add(i);
        }

        for (Map.Entry<Integer, ArrayList<Integer>> entry : rowMap.entrySet()) {
            List<Integer> list = entry.getValue();
            int k = list.size();
            for (int i = 1; i < k; i++) {
                edge.get(list.get(i - 1)).add(list.get(i));
                edge.get(list.get(i)).add(list.get(i - 1));
            }
        }

        boolean[] vis = new boolean[n];
        int num = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                num++;
                dfs(i, edge, vis);
            }
        }
        return n - num;
    }

    public void dfs(int x, List<List<Integer>> edge, boolean[] vis) {
        vis[x] = true;
        for (int y : edge.get(x)) {
            if (!vis[y]) {
                dfs(y, edge, vis);
            }
        }
    }


}
