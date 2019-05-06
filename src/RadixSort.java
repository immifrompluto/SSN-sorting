import java.util.ArrayList;
import java.util.Collections;

/**
 * RadixSort class that sorts the list of SSNs using the RadixSort sorting algorithm
 */
public class RadixSort {
    /**
     * radixSort method that sorts the arrayList by LSD
     * @param A
     * @param d
     */
    public void radixSort(ArrayList<Integer> A, int d){
        ArrayList<Integer> B = new ArrayList<>(); //New arrayList to store the sorted digits
        //Calls counting sort on every single digit recursively
        for(int i = 1; Collections.max(A)/i > 0; i *= 10){
            countSort(A, d, i);
        }
    }

    /**
     * countSort method that sorts the elements based on each digit given by radixSort method in linear time
     * @param A
     * @param d
     * @param k
     */
    public void countSort(ArrayList<Integer> A, int d, int k){
        ArrayList<Integer> D = new ArrayList<>(A.size()); //ArrayList of size A
        //Initializing all the values of D to 0, and A.size() values in D
        for(int i = 0; i < A.size(); i++){
            D.add(0);
        }
        ArrayList<Integer> C = new ArrayList<>(10);
        //The possibility of elements for single digit
        for(int i = 0; i < 10; i++){
            C.add(0);
        }
        //We count the number of j elements in ArrayList A , and place the count in ArrayList C
        for(int j = 0; j < A.size(); j++){
            C.set((A.get(j)/k)%10, C.get((A.get(j)/k)%10)+1);
        }
        //Adding the element of index i with the previous element
        for(int i = 1; i < 10; i++){
            C.set(i, C.get(i) + C.get(i-1));
        }
        // We are building the D array, and decrementing C in reverse order
        for(int j = A.size() - 1; j >= 0; j--){
            D.set(C.get((A.get(j)/k)%10) - 1, A.get(j));
            C.set((A.get(j)/k)%10, C.get((A.get(j)/k)%10) - 1);
        }
        //Copying the elements of D to the original array
        for(int i = 0; i < A.size(); i++){
            A.set(i, D.get(i));
        }
    }
}
