package hot150;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: hot68
 * Package: hot150
 * Description:
 *
 * @Author zbc
 * @Create 2024/10/31 下午2:08
 * @Version 1.0
 */
public class hot68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        // left记录当前行的开头 right记录当前走到哪个单词
        int left = 0, right = 0, n = words.length;
        // 依次处理每一行
        while(true){
            left = right;
            int numLen = 0; // 当前行单词总长度
            // 贪心 尽可能多往每行中放置单词
            while(right < n && numLen + words[right].length() + right - left <= maxWidth){
                numLen += words[right++].length();
            }

            // 当前行是最后一行, 单词左对齐, 后面用空格补齐
            if(right == n){
                StringBuilder sb = join(words, left, right, " ");
                sb.append(blank(maxWidth - sb.length()));
                ans.add(sb.toString());
                return ans;
            }

            int wordsNum = right - left;
            int spacesNum = maxWidth - numLen;

            // 当前行只有一个单词，单词左对齐，后面用空格补齐
            if(wordsNum == 1){
                StringBuilder sb = new StringBuilder(words[left]);
                sb.append(blank(spacesNum));
                ans.add(sb.toString());
                continue;
            }

            // 当前行不只一个单词，两端对齐，补充额外空格
            int avgSpaces = spacesNum / (wordsNum - 1);
            int extraSpaces = spacesNum % (wordsNum - 1);
            StringBuilder sb = new StringBuilder();
            sb.append(join(words, left, left + extraSpaces + 1, blank(avgSpaces + 1)));
            sb.append(blank(avgSpaces));
            sb.append(join(words, left + extraSpaces + 1, right, blank(avgSpaces)));
            ans.add(sb.toString());
        }
    }

    // 将该行从left 到 right 的单词连接，中间用sep连接
    private StringBuilder join(String[] words, int left, int right, String sep) {
        StringBuilder ans = new StringBuilder(words[left]);
        for(int i = left + 1; i < right; i++) {
            ans.append(sep);
            ans.append(words[i]);
        }
        return ans;
    }

    // 返回用m个空格组成的字符串
    private String blank(int m){
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < m; i++) {
            ans.append(" ");
        }
        return ans.toString();

    }


}
