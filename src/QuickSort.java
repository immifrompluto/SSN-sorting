import java.util.ArrayList;
import java.util.Collections;

/**
 * QuickSort class that sorts the list of SSNs using QuickSort
 */
public class QuickSort{
    /**
     * Creates partition and recursively calls itself unless the list is completely sorted
     * @param A
     * @param p
     * @param r
     */
    public void quickSort(ArrayList<Integer> A, int p, int r){
        if(p < r){
            int q = partition(A, p, r);
            quickSort(A, p, q-1);
            quickSort(A, q + 1, r);
        }
    }

    /**
     * Creates a pivot, compares the pivot with the numbers in array and swaps them if the number is lower than the pivot and returns a value to the quickSort() method
     * @param A
     * @param p
     * @param r
     * @return
     */
    public int partition(ArrayList<Integer> A, int p, int r){
        int x = A.get(r);   //Pivot
        int i = p-1;        //i is the index of the The element before p
        for(int j = p; j < r; j++){
            if(A.get(j) <= x){
                i = i+1;
                Collections.swap(A, i, j);
            }
        }
        Collections.swap(A,i+1, r); //Swap function
        return i+1;
    }

}
