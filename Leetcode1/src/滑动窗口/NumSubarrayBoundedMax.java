package 滑动窗口;

/**
 * ClassName: NumSubarrayBoundedMax
 * Package: 滑动窗口
 * Description:
 * 区间子数组个数 https://leetcode.cn/problems/number-of-subarrays-with-bounded-maximum/description/
 * @Author zbc
 * @Create 2024/7/3 9:52
 * @Version 1.0
 */
public class NumSubarrayBoundedMax {

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return countSubarrayLessThanOrEqual(nums, right) - countSubarrayLessThanOrEqual(nums, left - 1);
    }

    //元素小于等于bound的子数组个数
    public int countSubarrayLessThanOrEqual(int[] nums, int bound){
        int ans = 0;
        for(int l = 0, r = 0; r < nums.length; r++){
            if(nums[r] > bound) {
                l = r + 1;
            }else{
                ans += r - l + 1;
            }
        }
        return ans;
    }
}
