package 图.拓扑;

import java.util.ArrayList;

/**
 * ClassName: SequenceReconstruction
 * Package: 图.拓扑
 * Description:
 *
 * @Author zbc
 * @Create 2024/8/8 下午2:08
 * @Version 1.0
 */
public class SequenceReconstruction {
    public static boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        int n = nums.length;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegrees = new int[n + 1];
        for (int[] sequence : sequences) {
            for (int i = 0; i < sequence.length - 1; i++) {
                int from = sequence[i];
                int to= sequence[i + 1];
                graph.get(from).add(to);
                indegrees[to]++;
            }
        }
        int[] queue = new int[n];
        int l = 0, r = 0;
        for (int i = 1; i < indegrees.length; i++) {
            if(indegrees[i] == 0){
                queue[r++] = i;
            }
        }
        while(l < r){
            int size = r - l;
            if(size > 1){
                return false;
            }
            int cur = queue[l++];
            for (Integer to : graph.get(cur)) {
                if(--indegrees[to] == 0){
                    queue[r++] = to;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 5, 2, 6, 3};
        int[][] sequences = new int[][]{{5,2,6,3}, {4,1,5,2}};
        System.out.println(sequenceReconstruction(nums, sequences));
    }
}
