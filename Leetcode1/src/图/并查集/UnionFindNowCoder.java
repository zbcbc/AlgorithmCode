package 图.并查集;

import java.io.*;

/**
 * ClassName: UnionFindNowCoder
 * Package: 并查集
 * Description:
 *  https://www.nowcoder.com/practice/e7ed657974934a30b2010046536a5372
 *
 * @Author zbc
 * @Create 2024/8/21 上午10:17
 * @Version 1.0
 */
public class UnionFindNowCoder {
    public static int opt;
    public static int MAXN = 1000001;
    public static int[] father = new int[MAXN];
    public static int[] size = new int[MAXN];
    public static int[] stack = new int[MAXN];
    public static int n;
    public static int m;
    public static int x, y;

    public static void build(){
        for (int i = 0; i <= n; i++) {
            father[i] = i;
            size[i] = 1;
        }
    }

    public static int find(int a){
        return a == father[a] ? a : (father[a] = find(father[a]));
    }

    public static boolean isSameSet(int a, int b){
        return find(a) == find(b);
    }

    public static void union(int a, int b){
        int fx = find(a);
        int fy = find(b);
        if(fx != fy){
            if(size[fx] >= size[fy]){
                size[fx] += size[fy];
                father[fy] = fx;
            }else{
                size[fy] += size[fx];
                father[fx] = fy;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF){
            n = (int) in.nval;
            build();
            in.nextToken();
            m = (int) in.nval;
            for (int i = 0; i < m; i++) {
                in.nextToken();
                opt = (int) in.nval;
                in.nextToken();
                x = (int) in.nval;
                in.nextToken();
                y = (int) in.nval;
                if(opt == 1){
                    out.println(isSameSet(x, y) ? "Yes" : "No");
                }else {
                    union(x, y);
                }
            }
        }
        out.flush();
        br.close();
        out.close();
    }

}
