package 图.洪水填充;

/**
 * ClassName: HitBricks
 * Package: 图
 * Description:
 *
 * @Author zbc
 * @Create 2024/7/24 上午10:53
 * @Version 1.0
 */
public class HitBricks {
    // 1. 所有炮弹的位置-1  这样1变为0,0变为-1,和天花板就不连了
    // 2. 洪水填充 天花位的位置为2
    // 3. 倒流 炮弹位置+1 洪水填充 看2的数量是否有变化（连接天花板的数量）
    public static int[][] grid;
    public static int n, m;
    public int[] hitBricks(int[][] g, int[][] hits) {
        grid = g;
        n = g.length;
        m = g[0].length;
        int[] ans = new int[hits.length];

        //1. 炮弹位置-1
        for(int i = 0; i < hits.length; i++){
            grid[hits[i][0]][hits[i][1]]--;
        }

        //2. 洪水填充
        for(int i = 0; i < m; i++){
            if(grid[0][i] == 1){
                dfs(0, i);
            }
        }

        //3. 倒流
        for(int i = hits.length - 1, row, col; i >= 0; i--){
             row = hits[i][0];
             col = hits[i][1];
             grid[row][col]++;
            if (worth(row, col)) {
                ans[i] = dfs(row, col) - 1;
            }
        }
        return ans;

    }
    //遇到1就感染为2
    public int dfs(int i, int j){
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != 1){
            return 0;
        }
        grid[i][j] = 2;
        return 1 + dfs(i - 1, j) + dfs(i + 1, j) + dfs(i, j - 1) + dfs(i , j + 1);
    }

    public boolean worth(int i, int j) {
        return grid[i][j] == 1
                &&
                (i == 0
                        || (i > 0 && grid[i - 1][j] == 2)
                        || (i < n - 1 && grid[i + 1][j] == 2)
                        || (j > 0 && grid[i][j - 1] == 2)
                        || (j < m - 1 && grid[i][j + 1] == 2));
    }
}
