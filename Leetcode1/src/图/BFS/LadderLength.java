package 图.BFS;

import java.util.*;

/**
 * ClassName: LadderLength
 * Package: 图.BFS
 * Description:
 *
 * @Author zbc
 * @Create 2024/8/2 下午2:38
 * @Version 1.0
 */
public class LadderLength {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words = new HashSet<>(wordList);
        if(!words.contains(endWord)){
            return 0;
        }
        ArrayDeque<String> queue = new ArrayDeque<>();

        HashMap<String, Integer> map = new HashMap<>();
        queue.addLast(beginWord);
        map.put(beginWord, 1);

        while(!queue.isEmpty()){
            String curWord = queue.removeFirst();
            int path = map.get(curWord);

            for (int i = 0; i < curWord.length(); i++) {
                char[] cur = curWord.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    cur[i] = j;
                    String newWord = Arrays.toString(cur);
                    if(newWord.equals(endWord)){
                        return path + 1;
                    }
                    if(words.contains(newWord) && !map.containsKey(newWord)){
                        map.put(newWord, path + 1);
                        queue.addLast(newWord);
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(ladderLength("hit", "cog", list));
    }
}
