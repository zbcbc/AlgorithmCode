package 前缀树;

import java.util.HashMap;

/**
 * ClassName: 前缀树.TrieTree_Code01_2_review
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author zbc
 * @Create 2024/6/19 10:35
 * @Version 1.0
 */
public class TrieTree_Code01_2_review {
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

    public static TrieNode root = new TrieNode();

    public static void insert(int[] words){
        TrieNode node = root;
        node.pass++;
        for (int i = 0; i < words.length; i++) {
            if(!node.nexts.containsKey(words[i])){
                node.nexts.put(words[i], new TrieNode());
            }
            node = node.nexts.get(words[i]);
            node.pass++;
        }
        node.end++;
    }
    public static int preNumber(int[] words){
        TrieNode node = root;
        for (int i = 0; i < words.length; i++) {
            if(!node.nexts.containsKey(words[i])){
                return 0;
            }
            node = node.nexts.get(words[i]);
        }
        return node.pass;
    }
    public static int[] countConsistentKeys (int[][] b, int[][] a) {
        // write code here
        for(int[] nums : a){
            int[] words = new int[nums.length - 1];
            for(int i = 1; i < nums.length; i++){
                words[i - 1] = nums[i] - nums[i - 1];
            }
            insert(words);
        }
        int[] ans = new int[b.length];
        for(int i = 0; i < b.length; i++){
            int[] nums = b[i];
            int[] words = new int[nums.length - 1];
            for(int j = 1; j < nums.length; j++){
                words[j - 1] = nums[j] - nums[j - 1];
            }
            ans[i] = preNumber(words);
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
