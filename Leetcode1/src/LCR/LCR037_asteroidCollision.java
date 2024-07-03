package LCR;

import java.util.Stack;

/**
 * ClassName: LCR.LCR037_asteroidCollision
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author zbc
 * @Create 2024/5/24 11:37
 * @Version 1.0
 */
public class LCR037_asteroidCollision {
    public static int[] collision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for(int star : asteroids){
            boolean alive = true;
            while (alive && star < 0 && !st.isEmpty() && st.peek() > 0){
                alive = st.peek() < -star;
                if(st.peek() <= -star){
                    st.pop();
                }
            }
            if(alive){
                st.push(star);
            }
        }

        int[] res = new int[st.size()];
        for(int i = res.length - 1; i >=0; i--){
            res[i] = st.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] asteroids = {5, 10, -5};
        System.out.println(collision(asteroids));
    }
}


