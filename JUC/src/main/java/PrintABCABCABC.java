/**
 * ClassName: PrintABCABCABC
 * Package: PACKAGE_NAME
 * Description:
 *
 * 线程1输出a 5次，线程2输出b 5次，线程3输出c 5次。
 * 现在要求输出 abc abc abc abc abc 怎么实现？
 *
 * @Author zbc
 * @Create 2024/7/30 下午4:26
 * @Version 1.0
 */
public class PrintABCABCABC {
    private int flag;
    private int loopNumber;

    public PrintABCABCABC(int flag, int loopNumber){
        this.flag = flag;
        this.loopNumber = loopNumber;
    }

    public void print(String str, int waitFlag, int nextFlag){
        for (int i = 0; i < loopNumber; i++) {
            synchronized (this) {
                while(flag != waitFlag){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print(str);
                flag = nextFlag;
                this.notifyAll();
            }
        }
    }
    public static void main(String[] args) {
        PrintABCABCABC waitNotify = new PrintABCABCABC(1, 5);
        new Thread(() -> {
            waitNotify.print("a", 1, 2);
        },"t1").start();
        new Thread(() -> {
            waitNotify.print("b", 2, 3);
        },"t2").start();
        new Thread(() -> {
            waitNotify.print("c", 3, 1);
        },"t3").start();
    }
}


