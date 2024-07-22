package 图;

/**
 * ClassName: NumIsLands
 * Package: 图
 * Description:
 *
 * @Author zbc
 * @Create 2024/7/22 下午4:44
 * @Version 1.0
 */
public class NumIsLands {
    public int numIsLands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int res = 0;
        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    res++;
                    dfs(grid, i, j);
                }
            }
        }

        return res;
    }

    public void dfs(char[][] grid, int i, int j) {
        if(i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] != '1'){
            return;
        }

        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }
}
