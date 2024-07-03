import java.io.*;

/**
 * ClassName: HeapSort
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author zbc
 * @Create 2024/5/22 10:33
 * @Version 1.0
 */
public class HeapSort {
    public static int MAXN = 100001;
    public static int[] arr = new int[MAXN];
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new PrintWriter(System.out));
        while(in.nextToken() != StreamTokenizer.TT_EOF){
            n = (int) in.nval;
            for(int i = 0; i < n; i++){
                in.nextToken();
                arr[i] = (int)in.nval;
            }
            //heapSort1();
            heapSort2();
            for(int i = 0; i < n - 1; i++){
                out.print(arr[i] + " ");
            }
            out.println(arr[n - 1]);
        }
        out.flush();
        out.close();
        br.close();
    }

    // i位置的数,不断向上调整大根堆
    // i位置的数， 父: (i - 1)/2
    // 0的父亲还是0
    public static void heapInsert(int i){
        while(arr[i] > arr[(i - 1) / 2]){
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    // i位置的数，不断向下调整大根堆
    public static void heapify(int i, int size){
        int left = (i * 2) + 1; //左孩子
        //size为堆大小 找最强的孩子
        while(left < size){
            int best = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            best = arr[best] > arr[i]? best : i;
            //如果最强的是自己，不需要调整了
            if(best == i){
                break;
            }
            swap(best, i);
            //继续向下调整
            i = best;
            left = i * 2 + 1;
        }
    }

    // 从顶到底建立大根堆， O(n * logn)
    // 依次弹出堆内最大值并排序 O(n * logn)
    // 整体 O(n * logn)
    public static void heapSort1(){
        for(int i = 0; i < n; i++){
            heapInsert(i);
        }
        int size = n;
        while(size > 1){
            swap(0, --size);
            heapify(0, size);
        }
    }

    // 从底到顶建立大根堆，O(n)
    // 依次弹出堆内最大值并排好序，O(n * logn)
    // 整体时间复杂度O(n * logn)
    public static void heapSort2(){
        for(int i = n - 1; i >= 0; i--){
            heapify(i, n);
        }
        int size = n;
        while(size > 1){
            swap(0, --size);
            heapify(0, size);
        }
    }


    public static void swap(int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
