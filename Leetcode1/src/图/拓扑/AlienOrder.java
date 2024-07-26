package 图.拓扑;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * ClassName: AlienOrder
 * Package: 图.拓扑
 * Description:
 *
 * @Author zbc
 * @Create 2024/7/26 上午10:45
 * @Version 1.0
 */
public class AlienOrder {
    public String alienOrder(String[] words) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] indegrees = new int[26];
        Arrays.fill(indegrees, -1);
        for (String word : words) {
            for(int i = 0; i < word.length(); i++){
                indegrees[word.charAt(i) - 'a'] = 0;
            }
        }
        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0, len; i < words.length - 1; i++) {
            String cur = words[i];
            String next = words[i + 1];
            len = Math.min(cur.length(), next.length());
            int j = 0;
            for (; j < len; j++) {
                if(cur.charAt(j) != next.charAt(j)){
                    graph.get(cur.charAt(j) - 'a').add(next.charAt(j) - 'a');
                    indegrees[next.charAt(j) - 'a']++;
                    break;
                }
            }
            if(j == len && cur.length() > next.length()){
                return "";
            }
        }

        StringBuilder ans = new StringBuilder();
        int[] queue = new int[26];
        int l = 0, r = 0, kinds = 0;

        for (int i = 0; i < indegrees.length; i++) {
            if(indegrees[i] != -1){
                kinds++;
            }
            if(indegrees[i] == 0){
                queue[r++] = i;
            }
        }

        while(l < r){
            int cur = queue[l++];
            ans.append((char) (cur + 'a'));
            for (Integer next : graph.get(cur)) {
                if(--indegrees[next] == 0){
                    queue[r++] = next;
                }
            }
        }

        return ans.length() == kinds ? ans.toString() : "";
    }
}