package 前缀树;

import java.util.HashMap;

/**
 * ClassName: TrueTree2
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author zbc
 * @Create 2024/6/11 16:30
 * @Version 1.0
 */
public class TrieTree2 {
    class TrieNode{
        public int pass;
        public int end;
        HashMap<Integer, TrieNode> nexts;

        public TrieNode(){
            pass = 0;
            end = 0;
            nexts = new HashMap<>();
        }
    }

    private TrieNode root;

    public TrieTree2(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode node = root;
        node.pass++;
        for (int i = 0, path; i < word.length(); i++) {
            path = word.charAt(i);
            if(!node.nexts.containsKey(path)){
                node.nexts.put(path, new TrieNode());
            }
            node = node.nexts.get(path);
            node.pass++;

        }
        node.end++;
    }

    public int countWords(String word){
        TrieNode node = root;
        for (int i = 0, path; i < word.length(); i++) {
            path = word.charAt(i);
            if (!node.nexts.containsKey(path)) {
                return 0;
            }
            node = node.nexts.get(path);
        }
        return node.end;
    }

    public int countPrefix(String pre){
        TrieNode node = root;
        for (int i = 0, path; i < pre.length(); i++) {
            path = pre.charAt(i);
            if (!node.nexts.containsKey(path)) {
                return 0;
            }
            node = node.nexts.get(path);
        }
        return node.pass;
    }

    public void erase(String word){
        if (countWords(word) > 0) {
            TrieNode node = root;
            TrieNode next;
            node.pass--;
            for (int i = 0, path; i < word.length(); i++) {
                path = word.charAt(i);
                next = node.nexts.get(path);
                if (--next.pass == 0) {
                    node.nexts.remove(path);
                    return;
                }
                node = next;
            }
            node.end--;
        }
    }
}
