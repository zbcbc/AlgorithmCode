/**
 * ClassName: largest1BorderedSquare
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author zbc
 * @Create 2024/6/21 9:45
 * @Version 1.0
 */
public class largest1BorderedSquare {
    public static int largestSquare(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        build(n, m, grid);
        if(grid[n - 1][m - 1] == 0)
        {
            return 0;
        }
        int ans = 1;
        for(int a = 0; a < n; a++){
            for (int b = 0; b < m; b++){
                for(int c = a + ans, d = b + ans, k = ans + 1; c < n && d < m; c++, d++, k++){
                   //判断正方形
                    if(regionSum(a, b, c, d, grid) - regionSum(a + 1, b + 1, c - 1, d - 1, grid) == (k - 1) << 2){
                        ans = k;
                    }
                }
            }
        }
        return ans * ans;
    }
    public static void build(int n, int m, int[][] grid){
        for(int i = 0; i < n; i++){
            for (int j = 0; j < m; j++) {
                grid[i][j] += get(i, j - 1, grid) + get(i - 1, j, grid) - get(i - 1, j - 1, grid);
            }
        }
    }
    public static int get(int i, int j, int[][] grid) {
        return (i < 0 || j < 0) ? 0 : grid[i][j];
    }
    public static int regionSum(int a, int b, int c, int d, int[][] grid){
        return (a > c) ? 0 : grid[c][d] - get(c, b - 1, grid) - get(a - 1, d, grid) + get(a - 1, b- 1, grid);
    }
}
