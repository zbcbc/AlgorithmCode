package 堆;

import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.io.*;

/**
 * ClassName: HeapSort2
 * Package: 堆
 * Description:
 *
 * @Author zbc
 * @Create 2024/7/19 上午10:42
 * @Version 1.0
 */
public class HeapSort2 {
    public static int MAXN = 100001;
    public static int[] arr = new int[MAXN];
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF){
            n = (int) in.nval;
            for(int i = 0; i < n; i++){
                arr[i] = (int) in.nextToken();
            }
            heapsort();
            for(int i = 0; i < n - 1; i++){
                out.print(arr[i] + " ");
            }
            out.println(arr[n - 1]);
        }
        out.flush();
        out.close();
        br.close();
    }


    public static void heapsort(){
        for(int i = 0; i < n; i++){
            heapInsert(i); //比较是不是比父节点小
        }
        int size = n;
        while(size > 1){
            swap(0, --size);
            heapify(0, size); //变大了，向下调整
        }
    }

    public static void heapInsert(int i){
        while(arr[i] < arr[(i - 1) / 2]){
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }


    public static void swap(int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
