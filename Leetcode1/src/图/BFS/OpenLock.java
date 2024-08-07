package 图.BFS;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ClassName: OpenLock
 * Package: 图.BFS
 * Description:
 *
 * @Author zbc
 * @Create 2024/8/6 上午11:04
 * @Version 1.0
 */
public class OpenLock {
    public int openLock(String[] deadends, String target) {
        if(("0000").equals(target)){
            return 0;
        }
        HashSet<String> deadSet = new HashSet<>(Arrays.stream(deadends).collect(Collectors.toList()));
        if(deadSet.contains("0000")){
            return -1;
        }
        ArrayDeque<String> queue = new ArrayDeque<>();
        HashSet<String> visited = new HashSet<>();
        queue.add("0000");
        visited.add("0000");

        int level = 0;
        while (!queue.isEmpty()){
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                for (String next : getNext(cur)) {
                    if(next.equals(target)){
                        return level;
                    }
                    if(!visited.contains(next) && !deadSet.contains(next)){
                        visited.add(next);
                        queue.add(next);
                    }
                }
            }
        }
        return -1;

    }

    public char num1(char x){
        return x == '0' ? '9' : (char)(x - 1);
    }
    public char num2(char x){
        return x == '9' ? '0' : (char)(x + 1);
    }

    public String[] getNext(String cur){
        ArrayList<String> ans = new ArrayList<>();
        char[] array = cur.toCharArray();
        for (int i = 0; i < 4; i++) {
            char num = array[i];
            array[i] = num1(num);
            ans.add(new String(array));
            array[i] = num2(num);
            ans.add(new String(array));
            array[i] = num;
        }
        return ans.toArray(new String[ans.size()]);
    }
}
