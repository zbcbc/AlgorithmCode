package 图.DFS;

/**
 * ClassName: FindCircleNum
 * Package: 图.拓扑
 * Description:
 *
 * @Author zbc
 * @Create 2024/8/20 下午1:38
 * @Version 1.0
 */
public class FindCircleNum {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++){
            if(!visited[i]){
                ans++;
                dfs(isConnected, i, visited);
            }
        }

        return ans;
    }
    public void dfs(int[][] isConnected, int i, boolean[] visited){
//        if(visited[i]){
//            return;
//        }
        for (int j = 0; j < isConnected[i].length; j++) {
            if(isConnected[i][j] == 1 && !visited[j]){
                visited[j] = true;
                dfs(isConnected, j, visited);
            }
        }
    }
}
