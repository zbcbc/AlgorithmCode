package 滑动窗口;

/**
 * ClassName: TotalFruit
 * Package: 滑动窗口
 * Description:
 * 水果成篮 https://leetcode.cn/problems/fruit-into-baskets/
 * @Author zbc
 * @Create 2024/7/3 9:34
 * @Version 1.0
 */
public class TotalFruit {
    /**
     * 题意 至多包含两种元素的最长子串，返回其长度
     * @param fruits
     * @return
     */
    public int totalFruit(int[] fruits){
        int ans = 0;
        // 记录窗口内种类数
        int[] cnts = new int[fruits.length + 1];
        for(int l = 0, r = 0, collect = 0; r < fruits.length; r++){
            if(cnts[fruits[r]]++ == 0){
                collect++;
            }
            while(collect > 2){
                if(--cnts[fruits[l]] == 0){
                    collect--;
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
