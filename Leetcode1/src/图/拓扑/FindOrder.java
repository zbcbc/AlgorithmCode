package 图.拓扑;

import java.util.ArrayList;

/**
 * ClassName: FindOrder
 * Package: 图.拓扑
 * Description:
 *
 * @Author zbc
 * @Create 2024/8/8 下午1:41
 * @Version 1.0
 */
public class FindOrder {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] queue = new int[numCourses];
        int l = 0, r = 0;
        int[] indegrees = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
            indegrees[prerequisite[0]]++;
        }
        int count = 0;
        for (int i = 0; i < indegrees.length; i++) {
            if(indegrees[i] == 0){
                queue[r++] = i;
                count++;
            }
        }
        while (l < r){
            int cur = queue[l++];
            for (Integer to : graph.get(cur)) {
                if(--indegrees[to] == 0){
                    queue[r++] = to;
                    count++;
                }
            }
        }

        return count == numCourses ? queue : new int[0];
    }
}
