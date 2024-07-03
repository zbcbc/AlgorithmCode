import java.io.*;

/**
 * ClassName: DiffMatrix
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author zbc
 * @Create 2024/6/21 11:31
 * @Version 1.0
 */
public class DiffMatrix {
    public static int n, m, q;
    public static int MAXN = 1005;
    public static int MAXM = 1005;
    public static long[][] diff = new long[MAXN][MAXM];  //防止溢出
    public static int a, b, c, d, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while(in.nextToken() != StreamTokenizer.TT_EOF){
            //n行
            n = (int) in.nval;
            //每行m个数
            in.nextToken();
            m = (int) in.nval;
            //q次操作
            in.nextToken();
            q = (int) in.nval;

            for (int i = 1; i <= n; i++){
                for(int j = 1 ; j <= m; j++){
                    in.nextToken();
                    //构建原数组元素时也按差分处理
                    add(i, j, i, j , (int) in.nval);
                }
            }
            //q次操作
            for (int i = 0; i < q; i++){
                in.nextToken();
                a = (int) in.nval;
                in.nextToken();
                b = (int) in.nval;
                in.nextToken();
                c = (int) in.nval;
                in.nextToken();
                d = (int) in.nval;
                in.nextToken();
                k = (int) in.nval;
                add(a, b, c, d, k);
            }
            build();

            for(int i = 1; i <= n; i++){
                out.print(diff[i][1]);
                for(int j = 2; j <= m; j++){
                    out.print(" " + diff[i][j]);
                }
                out.println();
            }
            clear();
        }
        out.flush();
        br.close();
        out.close();
    }
    public static void add(int a, int b, int c, int d, int k){
        diff[a][b] += k;
        diff[c + 1][b] -= k;
        diff[a][d + 1] -= k;
        diff[c + 1][d + 1] += k;
    }

    public static void build(){
        for(int i = 1;  i <= n; i++){
            for(int j = 1; j <= m; j++){
                diff[i][j] += diff[i - 1][j] + diff[i][j - 1] - diff[i - 1][j - 1];
            }
        }
    }
    public static void clear() {
        for (int i = 1; i <= n + 1; i++) {
            for (int j = 1; j <= m + 1; j++) {
                diff[i][j] = 0;
            }
        }
    }
}
