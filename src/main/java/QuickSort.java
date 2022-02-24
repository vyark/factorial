import java.util.Random;
import java.util.concurrent.RecursiveTask;

public class QuickSort extends RecursiveTask<Integer> {

    private int start, end;
    private int[] arr;

    private int partition(int start, int end, int[] arr) {
        int i = start, j = end;
        int pivote = new Random().nextInt(j - i) + i;

        int t = arr[j];
        arr[j] = arr[pivote];
        arr[pivote] = t;
        j--;

        while (i <= j) {
            if (arr[i] <= arr[end]) {
                i++;
                continue;
            }
            if (arr[j] >= arr[end]) {
                j--;
                continue;
            }
            t = arr[j];
            arr[j] = arr[i];
            arr[i] = t;
            j--;
            i++;
        }

        t = arr[j + 1];
        arr[j + 1] = arr[end];
        arr[end] = t;
        return j + 1;
    }

    public QuickSort(int start, int end, int[] arr) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (start >= end)
            return null;

        int p = partition(start, end, arr);

        QuickSort left = new QuickSort(start, p - 1, arr);
        QuickSort right = new QuickSort(p + 1, end, arr);

        left.fork();
        right.compute();
        left.join();

        return null;
    }
}
