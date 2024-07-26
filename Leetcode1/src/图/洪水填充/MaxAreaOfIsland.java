package 图.洪水填充;

/**
 * ClassName: MaxAreaOfIsland
 * Package: 图
 * Description:
 *
 * @Author zbc
 * @Create 2024/7/24 下午2:51
 * @Version 1.0
 */
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    ans = Math.max(ans, dfs(grid, n, m, i, j));
                }
            }
        }
        return ans;

    }
    public int dfs(int[][] grid, int n, int m, int i, int j){
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != 1){
            return 0;
        }
        grid[i][j] = 2;
        return 1 + dfs(grid, n, m, i - 1, j) + dfs(grid, n, m, i + 1, j) + dfs(grid, n, m, i, j - 1) + dfs(grid, n, m, i, j + 1);
    }
}
