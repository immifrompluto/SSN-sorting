import java.util.ArrayList;

/**
 * Bucket sort class that sorts the list of SSNs using BucketSort
 */
public class BucketSort {

    // In this bucket sort, a nested array list is created i.e. an array list containing an ArrayList
    // as the items. Th nested ArrayList is the bucket where each of the element will be stored based on the bucket
    // number which is assigned to that element based on total buckets and increase.
    public void bucketSort(ArrayList<Integer> A, int min, int max){

        int n = A.size();
        int totalBuckets = (int) Math.ceil(n / 30);  //10 buckets
        ArrayList<ArrayList<Integer>> B = new ArrayList<>(totalBuckets);
        //Initializing every ArrayList of the B array
        for(int i= 0; i < totalBuckets; i++){
            B.add(new ArrayList<>());
        }

        int dif = max - min;
        //Determining the bucket number in which the element needs to be placed, and we are placing the elements in that bucket
        for(int i = 0; i < n; i++){
            int increase = (int)Math.ceil(dif/totalBuckets);
            if(increase <= 0) {
                increase = 1;
            }
            int itemBucket = A.get(i) / increase;
            if(itemBucket < 0){
                itemBucket = 0;
            } else if (itemBucket >= totalBuckets){
                itemBucket = totalBuckets - 1;
            }
            B.get(itemBucket).add(A.get(i));
        }
        int index = 0;
        //Iterating over each bucket and sorting each bucket with InsertionSort separately, and concatenating all the bucket elements to A to get the overall sorted list
        for(int i = 0; i < B.size(); i++){
            insertionSort(B.get(i));
            for (int j = 0; j < B.get(i).size(); j++){
                A.set(index++, B.get(i).get(j));
            }
        }
    }
    // InsertionSort method that sorts element given by bucketSort method
    public void insertionSort(ArrayList<Integer> A){
        for(int j = 2; j < A.size(); j++){
            int key = A.get(j);
            int i = j -1;
            while(i > - 1 && A.get(i) > key){
                A.set(i+1, A.get(i));
                i = i - 1;
            }
            A.set(i+1, key);
        }
    }
}