package 图.BFS;

/**
 * ClassName: MaxDistance
 * Package: 图.BFS
 * Description:
 *
 * @Author zbc
 * @Create 2024/7/31 上午10:19
 * @Version 1.0
 */
public class MaxDistance {
    public static int MAXN = 101;
    public static int[][] queue = new int[MAXN * MAXN][2];
    public static boolean[][] visited = new boolean[MAXN][MAXN];
    public static int n;
    public static int l, r;
    public static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int maxDistance(int[][] grid) {
        n = grid.length;
        l = r = 0;
        int seas = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    queue[r][0] = i;
                    queue[r++][1] = j;
                    visited[i][j] = true;
                }else{
                    visited[i][j] = false;
                    seas++;
                }
            }
        }
        if(seas == 0 || seas == n * n){
            return -1;
        }
        //整层弹出
        int level = 0;
        while(l < r){
            level++;
            int size = r - l;
            while(size-- > 0){
                int curX = queue[l][0];
                int curY = queue[l++][1];
                for (int i = 0, nextX, nextY; i < 4; i++) {
                    nextX = curX + move[i][0];
                    nextY = curY + move[i][1];
                    if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && grid[nextX][nextY] == 0 && !visited[nextX][nextY]) {
                        queue[r][0] = nextX;
                        queue[r++][1] = nextY;
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
        return level - 1;
    }
}
