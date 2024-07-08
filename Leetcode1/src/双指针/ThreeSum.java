package 双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: ThreeSum
 * Package: 双指针
 * Description:https://leetcode.cn/problems/1fGaJU/submissions/544276182/?envType=study-plan-v2&envId=coding-interviews-special
 *
 * @Author zbc
 * @Create 2024/7/5 下午4:00
 * @Version 1.0
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);


        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            for(int l = i + 1, r = nums.length - 1; l < r;){
                if(nums[i] + nums[l] + nums[r] > 0){
                    r--;
                } else if (nums[i] + nums[l] + nums[r] < 0) {
                    l++;
                } else{
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while(l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]){
                        r--;
                    }
                    l++;
                    r--;
                }
            }
        }

        return res;
    }
}
