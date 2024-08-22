package 图.并查集;

import java.util.HashMap;

/**
 * ClassName: RemoveStones
 * Package: 并查集
 * Description:
 *
 * @Author zbc
 * @Create 2024/8/22 上午10:39
 * @Version 1.0
 */
public class RemoveStones {
    public static HashMap<Integer, Integer> rowFirst = new HashMap<>();
    public static HashMap<Integer, Integer> colFirst = new HashMap<>();
    public static int MAXN = 1001;
    public static int[] father = new int[MAXN];
    public static int sets;

    public static int removeStones(int[][] stones) {
        int n = stones.length;
        build(n);
        for (int i = 0; i < stones.length; i++) {
            int row = stones[i][0];
            int col = stones[i][1];
            if(!rowFirst.containsKey(row)){
                rowFirst.put(row, i);
            }else{
                union(rowFirst.get(row), i);
            }

            if(!colFirst.containsKey(col)){
                colFirst.put(col, i);
            }else{
                union(colFirst.get(col), i);
            }
        }

        return n - sets;
    }

    public static void build(int n){
        rowFirst.clear();
        colFirst.clear();
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
        sets = n;
    }
    public static int find(int x){
        return father[x] == x ? x : (father[x] = find(father[x]));
    }
    public static void union(int x, int y){
        int fx = find(x);
        int fy = find(y);
        if(fx != fy){
            father[fx] = fy;
            sets--;
        }
    }

}
