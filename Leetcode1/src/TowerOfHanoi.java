/**
 * ClassName: TowerOfHanoi
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author zbc
 * @Create 2024/6/3 10:03
 * @Version 1.0
 */
public class TowerOfHanoi {
    public static void haoni(int n){
        if(n > 0){
            f(n, "左", "中", "右");
        }
    }

    /**
     * i
     * @param i 目前圆盘上还有从 i至1 的圆盘
     * @param from
     * @param to
     * @param other
     */
    public static void f(int i, String from, String to, String other){
        if(i == 1){ //i = 1就不需要分解，直接移动
            System.out.println("移动圆盘1从" + from + "到" + to);
        }else{
            f(i - 1, from, other, to); //第一步 将上面i-1到1的圆盘移到other
            System.out.println("移动圆盘" + i + "从" + from + "到" + to); //第二步 将i圆盘移到to
            f(i - 1, other, to, from); //第三步 将i-1到1的圆盘从other移到to
        }
    }

    public static void main(String[] args) {
        int n = 3;
        haoni(3);
    }
}
