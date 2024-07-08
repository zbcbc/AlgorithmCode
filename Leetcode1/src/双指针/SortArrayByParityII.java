package 双指针;

/**
 * ClassName: SortArrayByParityII
 * Package: 双指针
 * Description:
 *
 * @Author zbc
 * @Create 2024/7/5 上午10:38
 * @Version 1.0
 */
public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] nums) {
        for(int odd = 1, even = 0; odd < nums.length && even < nums.length; ) {
            if((nums[nums.length - 1] & 1) == 1){
                swap(nums, odd, nums.length - 1);
                odd += 2;
            }else{
                swap(nums, even, nums.length - 1);
                even += 2;
            }
        }
        return nums;
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
