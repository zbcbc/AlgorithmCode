package 图.洪水填充;

/**
 * ClassName: LargestIsLand
 * Package: 图
 * Description: https://leetcode.cn/problems/making-a-large-island/
 *
 * @Author zbc
 * @Create 2024/7/24 上午9:45
 * @Version 1.0
 */
public class LargestIsLand {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int id = 2;
        // 编号
        for (int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    dfs(grid, i, j, id++);
                }
            }
        }
        // 计算面积
        int[] size = new int[id + 1];
        int ans = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if(grid[i][j] != 0){
                    ans = Math.max(ans, ++size[grid[i][j]]);
                }
            }
        }
        // 遍历0，上下左右面积和，注意去重
        boolean[] visited = new boolean[id + 1];
        int right, left, up, down, merge;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if(grid[i][j] == 0){
                    up = i > 0 ? grid[i - 1][j] : 0;
                    down = i + 1 < n ? grid[i + 1][j] : 0;
                    left = j > 0 ? grid[i][j - 1] : 0;
                    right = j + 1 < m ? grid[i][j + 1] : 0;
                    visited[up] = true;
                    merge = 1 + size[up];
                    if(!visited[down]){
                        visited[down] = true;
                        merge += size[down];
                    }
                    if(!visited[left]){
                        visited[left] = true;
                        merge += size[left];
                    }
                    if(!visited[right]){
                        visited[right] = true;
                        merge += size[right];
                    }
                    ans = Math.max(ans, merge);
                    visited[up] = false;
                    visited[down] = false;
                    visited[right] = false;
                    visited[left] = false;
                }
            }
        }
        return ans;
    }

    /**
     * 使用dfs给岛屿编号
     * @param grid
     * @param i
     * @param j
     * @param id
     */
    public void dfs(int[][] grid, int i, int j, int id){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1){
            return;
        }
        grid[i][j] = id;
        dfs(grid, i - 1, j, id);
        dfs(grid, i + 1, j, id);
        dfs(grid, i, j - 1, id);
        dfs(grid, i, j + 1, id);
    }
}
