package 图.BFS;

import java.util.ArrayList;

/**
 * ClassName: NumSimilarGroups
 * Package: 图.BFS
 * Description:
 *
 * @Author zbc
 * @Create 2024/8/20 下午2:31
 * @Version 1.0
 */
public class NumSimilarGroups {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++){
                if(checkSimilar(strs[i], strs[j])){
                    graph.get(i).add(j);
                }
            }
        }

        int ans = 0;
        boolean[] visited = new boolean[n];
        int[] queue = new int[n];
        int l = 0, r = 0;
        // 计算连通分量
        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                queue[r++] = i;
                while(l < r){
                    int cur = queue[l++];
                    visited[cur] = true;
                    for (Integer to : graph.get(cur)) {
                        if(!visited[to]){
                            queue[r++] = to;
                        }
                    }
                }
                ans++;
            }

        }
        return ans;
    }

    public boolean checkSimilar(String str1, String str2){
        int num = 0;
        for (int i = 0; i < str1.length(); i++) {
            if(str1.charAt(i) != str2.charAt(i)){
                num++;
                if(num > 2){
                    return false;
                }
            }
        }
        return true;
    }
}
