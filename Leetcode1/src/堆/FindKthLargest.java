package 堆;

/**
 * ClassName: FindKthLargest
 * Package: 堆
 * Description:
 *
 * @Author zbc
 * @Create 2024/7/19 下午12:25
 * @Version 1.0
 */
public class FindKthLargest {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(nums, 2));
    }

    //大根堆
    public static int findKthLargest(int[] nums, int k) {
        int size = nums.length;
        buildMaxHeap(nums);
        for(int i = 0; i < k - 1; i++){
            swap(nums, 0, --size);
            heapify(nums, 0, size);
        }
        return nums[0];
    }

    public static void buildMaxHeap(int[] nums){
        for(int i = 0; i < nums.length; i++){
            heapInsert(nums, i);
        }
    }
    public static void heapInsert(int[] nums, int i){
        while(nums[i] > nums[(i - 1) / 2]){
            swap(nums, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }
    public static void heapify(int[] nums, int i, int size){
        int left = 2 * i + 1;
        while(left < size){
            int best = left + 1 < size && nums[left + 1] > nums[left] ? left +1 : left;
            best = nums[best] > nums[i]? best : i;
            if(best == i){
                break;
            }
            swap(nums, best, i);
            i = best;
            left = i * 2 + 1;

        }
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }



}
