import java.util.HashMap;

/**
 * ClassName: LongestWPI
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author zbc
 * @Create 2024/6/15 16:15
 * @Version 1.0
 */
public class LongestWPI {
    public static int compute(int[] hours) {

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int ans = 0;
        for(int i = 0, sum = 0; i < hours.length; i++){
            sum += hours[i] > 8 ? 1 : -1;
            if(sum > 0){
                ans = i + 1;
            }else{
                if(map.containsKey(sum - 1)){
                    ans = Math.max(ans, i - map.get(sum - 1));
                }
            }
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] hours = {9,9,6,0,6,6,9};
        System.out.println(compute(hours));
    }
}
