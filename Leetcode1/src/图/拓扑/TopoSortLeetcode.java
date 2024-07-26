package 图.拓扑;

import java.util.ArrayList;

/**
 * ClassName: FindOrder
 * Package: 图.拓扑
 * Description:
 *
 * @Author zbc
 * @Create 2024/7/25 下午6:18
 * @Version 1.0
 */
public class TopoSortLeetcode {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegrees = new int[numCourses];
        // 建图、统计入度
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
            indegrees[prerequisite[0]]++;
        }

        // 统计入度为0的节点个数
        int count = 0;

        // 将入度为0的入队
        int[] queue = new int[numCourses];
        int l = 0, r = 0;
        for (int i = 0; i < numCourses; i++){
            if(indegrees[i] == 0){
                queue[r++] = i;
                count++;
            }
        }

        // 出队，同时删除对应的入度，将入度为0的再加入队列
        while(l < r){
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


