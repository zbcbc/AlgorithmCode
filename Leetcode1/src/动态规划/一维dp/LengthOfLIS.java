package 动态规划.一维dp;

/**
 * ClassName: LengthOfLIS
 * Package: 动态规划.一维dp
 * Description:
 *
 * @Author zbc
 * @Create 2024/9/9 下午9:02
 * @Version 1.0
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        // len 目前求得的 最长递增子序列的长度
        int n = nums.length, len = 1;
        // minends[i]: 长度为i的最长递增子序列 末尾元素的最小值（越小越好）
        int[] minends = new int[n + 1];
        minends[1] = nums[0];
        // 遍历nums
        for (int i = 1; i < n; i++) {
            // 比当前子序列末尾元素更大，成为更长的子序列
            if(nums[i] > minends[len]){
                minends[++len] = nums[i];
            }else{
                // 否则在minends数组1...len中二分查找，找到第一个大于或等于 nums[i] 的数的位置k，并用 nums[i] 替换它。这是为了保证 d 数组仍然保持最小的递增序列末尾值
                // 即 nums[k-1] < nums[i] < nums[k]，找到后更新 minends[k] = nums[i] 注意k在minends即为当前长度为k
                // 比如 [2,3,6,9],len=4, nums[i] = 5, 第一个>=5的数为6，位置为3,
                int l = 1, r = len, k = 0;
                while(l <= r){
                    int mid = l + (r - l) / 2;
                    if(minends[mid] >= nums[i]){
                        k = mid;
                        r = mid - 1;
                    }else{
                        l = mid + 1;
                    }
                }
                minends[k] = nums[i];
            }
        }
        return len;
    }
}
