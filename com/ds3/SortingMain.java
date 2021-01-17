import java.lang.reflect.Array;
import java.util.Arrays;

public class SortingMain {
    public static void main(String[] args) {
        int [] array = {5,4,3,2,1};
        // new BubbleSort();
        // new SelectionSort();
        // new InsertionSort();
        // new MergeSort();
        // new QuickSort();
        // new CountingSort();
        var sorter = new BucketSort();
        sorter.sort(array,3);
        System.out.println(Arrays.toString(array));
    }
}
