package 图.BFS;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * ClassName: LadderLength_review
 * Package: 图.BFS
 * Description:
 *
 * @Author zbc
 * @Create 2024/8/6 上午10:30
 * @Version 1.0
 */
public class LadderLength_review {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)){
            return 0;
        }
        HashMap<String, Integer> map = new HashMap<>();
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        map.put(beginWord, 1);

        while (!queue.isEmpty()){
            String cur = queue.poll();
            int path = map.get(cur);
            for(int i = 0; i < cur.length(); i++){
                char[] array = cur.toCharArray();
                for (int j = 0; j < 26; j++) {
                    array[i] = (char) (j + 'a');
                    String newWord = String.valueOf(array);
                    if(newWord.equals(endWord)){
                        return path + 1;
                    }
                    if(set.contains(newWord) && !map.containsKey(newWord)){
                        queue.add(newWord);
                        map.put(newWord, path + 1);
                    }

                }
            }
        }
        return 0;
    }
}
