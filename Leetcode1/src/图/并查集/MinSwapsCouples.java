package 图.并查集;

/**
 * ClassName: MinSwapsCouples
 * Package: 并查集
 * Description:
 *
 * @Author zbc
 * @Create 2024/8/21 下午3:05
 * @Version 1.0
 */
public class MinSwapsCouples {
    public static int MAXN = 31;
    public static int[] father = new int[MAXN];
    public static int m;
    public static int setsNumber;

    public static int minSwapsCouples(int[] row) {
        int n = row.length;
        m = n / 2; // m对情侣
        build(m);
        // 如果人的编号分别为 2 3
        // 那么他们的情侣编号就是1 即 人的编号 / 2 = 情侣编号
        for (int i = 0; i < n ; i += 2) {
            union(row[i] / 2, row[i + 1] / 2);
        }
        return m - setsNumber;
    }
    public static void build(int m){
        for (int i = 0; i < m; i++) {
            father[i] = i;
        }
        setsNumber = m;
    }
    public static int find(int x){
        return father[x] == x ? x : (father[x] = find(father[x]));
    }
    public static void union(int x, int y){
        int fx = find(x);
        int fy = find(y);
        if(fx != fy){
            father[fx] = fy;
            setsNumber--;
        }
    }
}
