package 图.拓扑.扩展技巧;

/**
 * ClassName: MaximumEmployeesToBeInvitedToAMeeting
 * Package: 图.拓扑.扩展技巧
 * Description:
 *
 * @Author zbc
 * @Create 2024/7/30 下午3:38
 * @Version 1.0
 */
public class MaximumEmployeesToBeInvitedToAMeeting {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] indegrees = new int[n];
        for (int i = 0; i < favorite.length; i++) {
            indegrees[favorite[i]]++;
        }
        int[] queue = new int[n];
        int l = 0, r = 0;
        for (int i = 0; i < indegrees.length; i++) {
            if(indegrees[i] == 0){
                queue[r++] = i;
            }
        }

        //deep[i] 不包括i在内，i之前的最长链的长度 使用拓扑不断将长度传递给下层节点
        int[] deep = new int[n];
        while (l < r){
            int cur = queue[l++];
            int next = favorite[cur];
            deep[next] = Math.max(deep[next], 1 + deep[cur]); //传递
            if(--indegrees[next] == 0){
                queue[r++] = next;
            }
        }

        //所有不在环上的点都已经删除了，剩下的都是一个一个的环
        // 可能性1: 所有小环（节点数为2）的中心点(2) + 两个中心点各自的最长链长度 -> 总个数
        int sumOfSmallRing = 0;
        // 可能性2: 所有大环（节点数>2），只算中心点 -> 最大环的中心点个数
        int bigRings = 0;
        for (int i = 0; i < indegrees.length; i++) {
            if(indegrees[i] > 0){
                int ringSize = 1;
                indegrees[i] = 0;
                for (int j = favorite[i]; j != i; j = favorite[j]){
                    ringSize++;
                    indegrees[j] = 0;
                }
                if(ringSize == 2){
                    sumOfSmallRing += 2 + deep[i] + deep[favorite[i]];
                } else {
                    bigRings = Math.max(bigRings, ringSize);
                }
            }
        }

        return Math.max(sumOfSmallRing, bigRings);
    }
}
