package 图.DFS;

/**
 * ClassName: LongestIncreasingPath
 * Package: 图.DFS
 * Description:
 *
 * @Author zbc
 * @Create 2024/8/7 下午2:09
 * @Version 1.0
 */
public class LongestIncreasingPath {
    int ans = Integer.MIN_VALUE;
    int[][] path;
    int n, m;
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        n = matrix.length; m = matrix[0].length;
        path = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, dfs(matrix, i, j));
            }
        }
        return ans;
    }

    public int dfs(int[][] matrix, int i, int j){
        if(path[i][j] != 0){
            return path[i][j];
        }
        path[i][j]++;
        for (int k = 0, x, y; k < 4; k++) {
            x = i + dirs[k][0];
            y = j + dirs[k][1];
            if(x >= 0 && x < n && y >= 0 && y < m && matrix[i][j] < matrix[x][y]){
                path[i][j] += Math.max(path[i][j], dfs(matrix, x, y));
            }
        }
        return path[i][j];
    }
}
