package 图.BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * ClassName: MinStickers
 * Package: 图.BFS
 * Description:
 *
 * @Author zbc
 * @Create 2024/7/31 下午12:40
 * @Version 1.0
 */
public class MinStickers {
    public int minStickers(String[] stickers, String target) {
        ArrayList<ArrayList<String>> graph = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }
        HashSet<String> visited = new HashSet<>();
        //建图: a -> xxx; b -> xxx; c -> xxx
        for (String sticker : stickers) {
            sticker = sort(sticker);
            for(int i = 0; i < sticker.length(); i++) {
                if(i == 0 || sticker.charAt(i) != sticker.charAt(i - 1)){
                    graph.get(sticker.charAt(i) - 'a').add(sticker);
                }
            }
        }

        target = sort(target);
        visited.add(target);
        String queue[] = new String[target.length() * stickers.length];
        int l = 0, r = 0;
        queue[r++] = target;
        int level = 1;

        //bfs 整层弹出
        while (l < r) {
            int size = r - l;
            while(size-- > 0){
                String cur = queue[l++];
                for (String s : graph.get(cur.charAt(0) - 'a')) {
                    String next = next(cur, s);
                    if(next.equals("")){
                        return level;
                    } else if (!visited.contains(next)) {
                        queue[r++] = next;
                        visited.add(next);
                    }
                }
            }
            level++;
        }
        return -1;
    }

    public String sort(String str){
        char[] array = str.toCharArray();
        Arrays.sort(array);
        return String.valueOf(array);
    }

    public String next(String t, String s){
        StringBuilder sb = new StringBuilder();
        for(int i = 0, j = 0; i < t.length();){
            //s走完了，将t后面的都加到sb上
            if(j == s.length()){
                sb.append(t.charAt(i++));
            }else {
                //t: b, s: a 匹配不上，由于t和s都排序过了，所以s要往后走，看后面的能否匹配上
                if(t.charAt(i) > s.charAt(j)){
                    j++;
                    // t: a, s: b 匹配不上，由于t和s都排序过了，所以s后面也是bcd...不可能是a，所以直接加到sb
                } else if (t.charAt(i) < s.charAt(j)) {
                    sb.append(t.charAt(i++));
                    //匹配上了，两个都往后走
                }else {
                    i++;
                    j++;
                }
            }
        }
        return sb.toString();
    }
}
