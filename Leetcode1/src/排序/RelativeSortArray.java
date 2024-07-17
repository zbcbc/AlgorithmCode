package 排序;

import java.util.Arrays;
import java.util.HashMap;

/**
 * ClassName: RelativeSortArray
 * Package: 排序
 * Description:
 *
 * @Author zbc
 * @Create 2024/7/17 下午3:00
 * @Version 1.0
 */
public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr2.length; i++){
            map.put(arr2[i], i);
        }

        return Arrays.stream(arr1).boxed().sorted((a, b) -> {
            if (map.containsKey(a) && map.containsKey(b)) {
                return map.get(a) - map.get(b);
            } else if (map.containsKey(a)) {
                return -1;
            } else if (map.containsKey(b)) {
                return 1;
            } else {
                return a - b;
            }
        }).mapToInt(Integer::valueOf).toArray();


    }
}
