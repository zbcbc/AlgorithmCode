package LCR;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

/**
 * ClassName: LCR.LCR061_kSmallestPairs
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author zbc
 * @Create 2024/5/23 10:39
 * @Version 1.0
 */
public class LCR061_kSmallestPairs {
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k){
        int len1 = nums1.length, len2 = nums2.length;
        List<List<Integer>> res = new ArrayList<>(k);
        //小根堆，放入三元组{nums1[u] + nums2[v], u, v}
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        //使用hashset去重
        HashSet<String> set = new HashSet<>();

        heap.offer(new int[]{nums1[0] + nums2[0], 0, 0});
        set.add(0 + "," + 0);

        while (k-- > 0 && !heap.isEmpty()){
            int[] poll = heap.poll();
            ArrayList<Integer> list = new ArrayList<>();
            list.add(nums1[poll[1]]);
            list.add(nums2[poll[2]]);
            res.add(list);

            if(poll[1] + 1 < len1 && !set.contains((poll[1] + 1) + "," + poll[2])){
                heap.offer(new int[]{nums1[poll[1] + 1] + nums2[poll[2]], poll[1] + 1, poll[2]});
                set.add((poll[1] + 1) + "," + poll[2]);
            }
            if(poll[2] + 1 < len2 && !set.contains(poll[1] + "," + (poll[2] + 1))){
                heap.offer(new int[]{nums1[poll[1]] + nums2[poll[2] + 1], poll[1], poll[2] + 1});
                set.add(poll[1] + "," + (poll[2] + 1));
            }
        }

        return res;
    }

    public static List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k){
        int len1 = nums1.length, len2 = nums2.length;
        List<List<Integer>> res = new ArrayList<>(k);
        //小根堆，放入三元组{nums1[u] + nums2[v], u, v}
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for(int i = 0; i < len1 && i < k; i++){
            heap.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }

        while (k-- > 0 && !heap.isEmpty()){
            int[] poll = heap.poll();
            ArrayList<Integer> list = new ArrayList<>();
            list.add(nums1[poll[1]]);
            list.add(nums2[poll[2]]);
            res.add(list);

            if(poll[2] + 1 < len2){
                heap.offer(new int[]{nums1[poll[1]] + nums2[poll[2] + 1], poll[1], poll[2] + 1});
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 1, 2};
        int[] nums2 = new int[]{1 , 2, 3};
        System.out.println(kSmallestPairs(nums1, nums2, 10));
    }
}
