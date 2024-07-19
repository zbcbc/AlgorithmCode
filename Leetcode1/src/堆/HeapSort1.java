package 堆;

import java.io.*;

/**
 * ClassName: HeapSort
 * Package: 堆
 * Description:
 *
 * @Author zbc
 * @Create 2024/7/18 下午3:24
 * @Version 1.0
 */
public class HeapSort1 {
    public static int MAXN = 100001;
    public static int[] arr = new int[MAXN];
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken();
            n = (int) in.nval;
            for(int i = 0; i < n; i++){
                in.nextToken();
                arr[i] = (int)in.nval;
            }
            heapSort();
            for(int i = 0; i < n - 1; i++){
                out.print(arr[i] + " ");
            }
            out.println(arr[n - 1]);

        out.flush();
        br.close();
        out.close();
    }

    public static void heapInsert(int i){
        while(arr[i] > arr[(i - 1) / 2]){
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public static void heapify(int i, int size){
        int left = i * 2 + 1;
        while(left < size){
            int best = left + 1 < size && arr[left] < arr[left + 1] ? left + 1 : left;
            best = arr[i] > arr[best] ? i : best;
            if(best == i){
                break;
            }
            swap(i, best);
            i = best;
            left = i * 2 + 1;
        }
    }

    public static void swap(int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void heapSort(){
        for (int i = 0; i < n; i++) {
            heapInsert(i);
        }
        int size = n;
        while(size > 1){
            swap(0, --size);
            heapify(0, size);
        }
    }

}
