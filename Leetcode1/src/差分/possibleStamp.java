package 差分;

/**
 * ClassName: 差分.possibleStamp
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author zbc
 * @Create 2024/6/21 19:45
 * @Version 1.0
 */
public class possibleStamp {
    //1. 原数组->补0 构建前缀和数组 通过二维前缀和 判断区域累加和是否等于0 如果等于0 那么可以贴邮票
    //2. 差分数组 如果可以贴邮票，那么在差分数组中作差分
    //最后判断 如果原数组为0 且 差分数组中也为0 说明没有被贴上邮票 返回false
    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] sum = new int[n + 1][m + 1];
        //构建二维前缀和数组 先补0 将原数值复制过去
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                sum[i][j] = grid[i - 1][j - 1];
            }
        }
        //计算二维前缀和
        build(sum);

        //差分数组 补一圈0
        int[][] diff = new int[n + 2][m + 2];
        //(a,b)为左上角点 (c,d)为右下角点 判断该区域和是否为0 为0就贴邮票
        for(int a = 1, c = a + stampHeight - 1; a <= n && c <= n; a++, c++){
            for (int b = 1, d = b + stampWidth - 1; b <= m && d <= m; b++, d++){
                if(regionSum(a, b, c, d,sum) == 0){
                    //贴邮票，在差分数组中对该区域+1 - 先差分第一步
                    add(a, b, c, d, diff);
                }
            }
        }
        //对差分数组求前缀和 - 差分最后一步
        build(diff);

        //作判断
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0 && diff[i + 1][j + 1] == 0){
                    return false;
                }
            }
        }

        return true;
    }
    public void build(int[][] sum){
        for(int i = 1; i < sum.length; i++){
            for(int j = 1; j < sum[0].length; j++){
                sum[i][j] += sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
            }
        }
    }

    public int regionSum(int a, int b, int c, int d, int[][] sum){
        return a > c ? 0 : (sum[c][d] - sum[c][b - 1] - sum[a - 1][d] + sum[a - 1][b - 1]);
    }

    public void add(int a, int b, int c, int d, int[][] diff){
        diff[a][b] += 1;
        diff[a][d + 1] -= 1;
        diff[c + 1][b] -= 1;
        diff[c + 1][d + 1] +=1;
    }
}
