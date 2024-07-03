package 前缀树;

import java.util.HashMap;

/**
 * ClassName: 前缀树.TrieTree_Code01_2
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author zbc
 * @Create 2024/6/12 11:46
 * @Version 1.0
 */
public class TrieTree_Code01_2 {
    static class TrieNode{
        public int pass;
        public int end;
        public HashMap<Integer, TrieNode> nexts;
        TrieNode(){
            pass = 0;
            end = 0;
            nexts = new HashMap<>();
        }
    }
    private static TrieNode root = new TrieNode();

    public static void insert(int[] word){
        TrieNode node = root;
        node.pass++;
        for(int i = 0; i < word.length; i++){
            int path = word[i];
            if(!node.nexts.containsKey(path)){
                node.nexts.put(path, new TrieNode());
            }
            node = node.nexts.get(path);
            node.pass++;
        }
        node.end++;
    }

    public static int searchPrefix(int[] pre) {
        TrieNode node = root;
        for (int i = 0; i < pre.length; i++) {
            int path = pre[i];
            if(!node.nexts.containsKey(path)){
                return 0;
            }
            node = node.nexts.get(path);
        }
        return node.pass;
    }

    public static int[] countConsistentKeys (int[][] b, int[][] a) {
        for(int[] nums : a){
            int[] word = new int[nums.length - 1];
            for(int i = 1; i < nums.length; i++){
                word[i - 1] = nums[i] - nums[i - 1];
            }
            insert(word);
        }

        int[] ans = new int[b.length];

        for(int i = 0; i < b.length; i++){
            int[] nums = b[i];
            int[] word = new int[nums.length - 1];
            for(int j = 1; j < nums.length; j++){
                word[j - 1] = nums[j] - nums[j - 1];
            }
            ans[i] = searchPrefix(word);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] b = {{1, 2, 3, 4, 5}, {2, 4, 6, 8}, {1, 4, 7, 10}};
        int[][] a= {{3, 4, 5, 6, 7, 8}, {2, 4, 6, 8}, {1, 3, 5, 7, 9}};
        int[] ans = countConsistentKeys(b, a);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
