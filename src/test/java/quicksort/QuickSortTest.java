package quicksort;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;

import static org.junit.Assert.assertEquals;

public class QuickSortTest {

    @Test
    public void testQuickSort(){
        int n = 7;
        int[] arr = {5, 77, 20, 44, 90, 13, 43};

        ForkJoinPool pool = ForkJoinPool.commonPool();

        pool.invoke(new QuickSort(0, n - 1, arr));

        int[] result = {5, 13, 20, 43, 44, 77, 90};

        for (int i = 0; i < n; i++)
            assertEquals(arr[i], result[i]);
    }
}
