package 前缀树;

import java.util.Arrays;

/**
 * ClassName: 前缀树.TrieTree_Code01
 * Package: PACKAGE_NAME
 * Description:
 *  https://www.nowcoder.com/practice/c552d3b4dfda49ccb883a6371d9a6932
 * @Author zbc
 * @Create 2024/6/12 10:35
 * @Version 1.0
 */
public class TrieTree_Code01 {
    public static int MAXN = 200000;
    public static int[][] tree = new int[MAXN][12];
    public static int[] pass = new int[MAXN];
    public static int[] end = new int[MAXN];

    public static int cnt;

    public static void build(){
        cnt = 1;
    }

    public static void clear(){
        for (int i = 1; i <= cnt; i++) {
            pass[i] = 0;
            end[i] = 0;
            Arrays.fill(tree[i], 0);
        }
    }

    public static int path(char c){
        if(c == '#'){
            return 10;
        } else if (c == '-') {
            return 11;
        }else {
            return c - '0';
        }
    }

    public static void insert(String word){
        int cur = 1;
        pass[cur]++;
        for (int i = 0, path; i < word.length(); i++) {
            path = path(word.charAt(i));
            if(tree[cur][path] == 0){
                tree[cur][path] = ++cnt;
            }
            cur = tree[cur][path];
            pass[cur]++;
        }
        end[cur]++;
    }

    public static int searchCount(String word){
        int cur = 1;
        for (int i = 0, path; i < word.length(); i++) {
            path = path(word.charAt(i));
            if(tree[cur][path] == 0){
                return 0;
            }
            cur = tree[cur][path];
        }
        return pass[cur];
    }


    public int[] countConsistentKeys (int[][] b, int[][] a){
        build();
        StringBuilder sb = new StringBuilder();
        //将a添加到前缀树中
        for(int[] nums : a){
            sb.setLength(0);
            for(int i = 1; i < nums.length; i++){
                sb.append(String.valueOf(nums[i] - nums[i - 1]) + '#');
            }
            insert(sb.toString());
        }
        int[] ans = new int[b.length];
        for(int i = 0; i < b.length; i++){
            sb.setLength(0);
            int[] nums = b[i];
            for(int j = 1; j < nums.length; j++){
                sb.append(String.valueOf(nums[j] - nums[j - 1]) + '#');
            }
            ans[i] = searchCount(sb.toString());
        }
        clear();
        return ans;
    }
}
