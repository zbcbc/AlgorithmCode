package 图.并查集;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: FindAllPeopleWithSecret
 * Package: 图.并查集
 * Description:
 *
 * @Author zbc
 * @Create 2024/8/23 下午1:41
 * @Version 1.0
 */
public class FindAllPeopleWithSecret {
    public static int MAXN = 100001;
    public static int[] father = new int[MAXN];
    // 集合的标签信息 : 设置集合的一些属性
    // secret[集合的代表元素] 代表集合的属性
    public static boolean[] secret = new boolean[MAXN];

    public static List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);
        int m = meetings.length;
        build(n, firstPerson);
        for (int l = 0, r; l < m; ) {
            r = l;
            while(r + 1 < m && meetings[l][2] == meetings[r + 1][2]){
                r++;
            }
            // l...r的会议为同一时刻
            for (int i = l; i <= r; i++){
                union(meetings[i][0], meetings[i][1]);
            }
            // 将该时刻 不知晓秘密的专家重新建立集合，即恢复成自己为一个集合
            for (int i = l, a, b; i <= r; i++){
                a = meetings[i][0];
                b = meetings[i][1];
                if (!secret[find(a)]) {
                    father[a] = a;
                }
                if (!secret[find(b)]) {
                    father[b] = b;
                }
            }
            l = r + 1;
        }
        for (int i = 0; i < n; i++) {
            if(secret[find(i)]){
                ans.add(i);
            }
        }
        return ans;
    }

    public static void build(int n, int firstPerson){
        for (int i = 0; i < n; i++) {
            father[i] = i;
            secret[i] = false;
        }
        secret[0] = true;
        father[firstPerson] = 0;
    }

    public static int find(int x){
        return father[x] == x ? x : (father[x] = find(father[x]));
    }

    public static void union(int x, int y){
        int fx = find(x);
        int fy = find(y);
        if(fx != fy){
            father[fx] = fy;
            // 代表元素为fy 更新集合的代表信息
            secret[fy] |= secret[fx];
        }
    }
}
