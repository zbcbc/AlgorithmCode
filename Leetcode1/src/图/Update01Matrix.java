package 图;

/**
 * ClassName: Update01Matrix
 * Package: 图
 * Description: 更新为元素到最近的 0 的距离
 *
 * @Author zbc
 * @Create 2024/8/3 上午10:38
 * @Version 1.0
 */
public class Update01Matrix {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] move = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        int[][] queue = new int[m * n][2];
        int l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(mat[i][j] == 1){
                   queue[r][0] = i;
                   queue[r][1] = j;
                }
            }
        }
        while (l < r) {
            int curX = queue[l][0];
            int curY = queue[l++][1];
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < 4; i++) {
                int nextX = curX + move[i][0];
                int nextY = curY + move[i][1];
                min = Math.min(min, mat[nextX][nextY]);
            }
            if(min == 1){
                queue[r][0] = curX;
                queue[r++][1] = curY;
            }else {
                mat[curX][curY] = 1 + min;
            }
        }
        return mat;
    }
}
