import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class middlleToBehind {
    public static String line;
    public static Deque<Character> stack;
    public static HashMap<Character, Integer> map = new HashMap(){
        {
            put('(', 0);
            put('+', 1);
            put('-', 1);
            put('*', 2);
            put('/', 2);
        }
    };
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        while((line = in.readLine()) != null){
            stack = new ArrayDeque<>();
            out.println(compute(line));
        }
        out.flush();
        in.close();
        out.close();
    }
    public static String compute(String line){
        line = line.replaceAll(" ", "");
        char[] strArray = line.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strArray.length; i++){
            char c = strArray[i];
            if(c >= 'a' && c <= 'z'){
                sb.append(c);
            }else if(c == '('){
                stack.push(c);
            }else if(c == ')'){
                while(!stack.isEmpty() && stack.peek() != '('){
                    sb.append(stack.pop());
                }
                stack.pop();
            }else{
                while(!stack.isEmpty() && map.get(stack.peek()) >= map.get(c)){
                    sb.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
