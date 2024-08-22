package 图.并查集;

/**
 * ClassName: NumSimilarGroups
 * Package: 并查集
 * Description:
 *
 * @Author zbc
 * @Create 2024/8/22 上午9:40
 * @Version 1.0
 */
public class NumSimilarGroups {
    public static int MAXN = 301;
    public static int[] father = new int[MAXN];
    public static int n;
    public static int num;
    public static int numSimilarGroups(String[] strs){
        n = strs.length;
        build();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if(checkSimilar(strs[i], strs[j])){
                    union(i, j);
                }
            }
        }
        return num;
    }

    public static void build(){
        num = n;
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }

    public static int find(int x){
        return father[x] == x ? x : (father[x] = find(father[x]));
    }

    public static void union(int x, int y){
        int fx = find(x);
        int fy = find(y);
        if(fx != fy){
            father[fx] = fy;
            num--;
        }
    }

    public static boolean checkSimilar(String a, String b) {
        int len = a.length();
        int cout = 0;
        for (int i = 0; i < len; i++) {
            if(a.charAt(i) != b.charAt(i)){
                cout++;
            }
            if(cout > 2){
                return false;
            }
        }
        return true;
    }


}
