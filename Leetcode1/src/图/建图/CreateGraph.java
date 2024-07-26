package 图.建图;

import java.util.ArrayList;

/**
 * ClassName: CreateGraph
 * Package: 图.建图
 * Description:
 *
 * @Author zbc
 * @Create 2024/7/25 上午10:41
 * @Version 1.0
 */
public class CreateGraph {
    // 点的最大数量
    public static int MAXN = 11;

    // 邻接矩阵方式建图
    public static int[][] graph1 = new int[MAXN][MAXN];

    // 邻接表方式建图
    // 无权图
    // public static ArrayList<ArrayList<Integer>> graph2 = new ArrayList<>();
    // 有权图
    public static ArrayList<ArrayList<int[]>> graph2 = new ArrayList<>();

    // 前期准备
    public static void bulid(int n){
        // 邻接矩阵清空
        for (int i = 1; i < n; i++){
            for (int j = 1; j < n; j++){
                graph1[i][j] = 0;
            }
        }
        // 邻接表清空和准备
        graph2.clear();
        // 下标需要支持1~n，要加入n+1个列表，0下标准备但不用
        for (int i = 0; i <= n; i++){
            graph2.add(new ArrayList<>());
        }
    }

    // 建立有向带权图
    public static void createGraph(int[][] edges){
        //邻接矩阵建图
        for (int[] edge : edges) {
            graph1[edge[0]][edge[1]] = edge[2];
        }

        // 邻接表建图
        for (int[] edge : edges) {
            graph2.get(edge[0]).add(new int[] {edge[1], edge[2]});
        }
    }
}
