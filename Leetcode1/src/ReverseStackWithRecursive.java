import java.util.Stack;

/**
 * ClassName: ReverseStackWithRecursive
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author zbc
 * @Create 2024/6/3 9:14
 * @Version 1.0
 */
public class ReverseStackWithRecursive {

    /**
     * 将栈底元素移除掉，上面的元素盖下来
     * @param stack
     * @return
     */
    public static int bottomOut(Stack<Integer> stack){
        int ans = stack.pop();
        if(stack.isEmpty()){
            return ans;
        }else{
            int last = bottomOut(stack);
            stack.push(ans);
            return last;
        }
    }

    /**
     * 逆序
     * @param stack
     */
    public static void reverse(Stack<Integer> stack) {
        if(stack.isEmpty()){
            return;
        }
        int num = bottomOut(stack);
        reverse(stack);
        stack.push(num);//取出来的最终要push回去 放在递归后 让前面的都放回去 再放
    }

    public static void main(String[] args) {
        Stack<Integer> integers = new Stack<>();
        integers.push(1);
        integers.push(2);
        integers.push(3);
        reverse(integers);
        while(!integers.isEmpty()){
            System.out.println(integers.pop());
        }
    }
}
