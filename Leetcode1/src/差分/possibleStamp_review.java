package 差分;

/**
 * ClassName: 差分.possibleStamp_review
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author zbc
 * @Create 2024/6/22 13:00
 * @Version 1.0
 */
public class possibleStamp_review {
    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        //1. 二维前缀和 如果区域累加和为0 那么能贴邮票
        //2. 在差分数组中贴上邮票
        //3. 判断
        int n = grid.length;
        int m = grid[0].length;
        int[][] sum = new int[n + 1][m + 1];
        for(int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                sum[i + 1][j + 1] = grid[i][j];
            }
        }

        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < m + 1; j++){
                sum[i][j] += sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
            }
        }


        int[][] diff = new int[n + 2][m + 2];
        for(int a = 1, c = a + stampHeight - 1; a < n + 1 && c < n + 1; a++, c++){
            for(int b = 1, d = b + stampWidth - 1; b < m + 1&& d < m + 1; b++, d++){
                if(regionSum(a, b, c, d, sum) == 0){
                    add(a, b, c, d, diff);
                }
            }
        }
        build(n, m, diff);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0 && diff[i + 1][j + 1] == 0){
                    return false;
                }
            }
        }

        return true;
    }

    public int regionSum(int a, int b, int c, int d, int[][] sum){
        return a > c ? 0 : (sum[c][d] - sum[c][b - 1] - sum[a - 1][d] + sum[a - 1][b - 1]);
    }

    public void add(int a, int b, int c, int d, int[][] diff){
        diff[a][b] += 1;
        diff[a][d + 1] -= 1;
        diff[c + 1][b] -= 1;
        diff[c + 1][d + 1] += 1;
    }
    public void build(int n, int m, int[][] diff){
        for(int i = 1; i < n + 2; i++){
            for(int j = 1; j < m + 2; j++){
                diff[i][j] += diff[i - 1][j] + diff[i][j - 1] - diff[i - 1][j - 1];
            }
        }
    }

}
