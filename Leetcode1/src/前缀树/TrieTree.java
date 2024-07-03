package 前缀树;

/**
 * ClassName: 前缀树.TrieTree
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author zbc
 * @Create 2024/6/11 15:35
 * @Version 1.0
 */
public class TrieTree {
    class TrieNode{
        private int pass;
        private int end;
        private TrieNode[] nexts;
        TrieNode(){
            pass = 0;
            end = 0;
            nexts = new TrieNode[26];
        }
    }

    private TrieNode root;

    public TrieTree(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode node = root;
        node.pass++;
        for(int i = 0, path; i < word.length(); i++){
            path = word.charAt(i) - 'a';
            if(node.nexts[path] == null){
                node.nexts[path] = new TrieNode();
            }
            node = node.nexts[path];
            node.pass++;
        }
        node.end++;
    }

    /**
     * 查询前缀树中word单词出现了几次
     * @param word
     * @return
     */
    public int countWords(String word){
        TrieNode node = root;
        for(int i = 0, path; i < word.length(); i++){
            path = word.charAt(i) - 'a';
            //如果没有 说明没出现过
            if(node.nexts[path] == null){
                return 0;
            }
            node = node.nexts[path];
        }
        return node.end;
    }

    /**
     * 查询以pre为前缀的单词有多少个
     * @param pre
     * @return
     */
    public int countPrefix(String pre){
        TrieNode node = root;
        for(int i = 0, path; i < pre.length(); i++){
            path = pre.charAt(i) - 'a';
            if(node.nexts[path] == null){
                return 0;
            }
            node = node.nexts[path];
        }
        return node.pass;
    }

    /**
     * 删除单词word
     * 如果没出现过，就什么也不做
     * @param word
     */
    public void erase(String word){
        if(countWords(word) > 0){
            TrieNode node = root;
            node.pass--;
            for(int i = 0, path; i < word.length(); i++){
                path = word.charAt(i) - 'a';
                if(--node.nexts[path].pass == 0){
                    //pass--后为0了，就可以把后续的删掉了
                    node.nexts[path] = null;
                    return;
                }
                node = node.nexts[path];
            }
            node.end--;
        }
    }
}
