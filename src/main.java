import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * main class that executes all the sorting
 */
public class main {

    /**
     * main method calls all the sorting
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        write();        //Calls write() method that is called to generate SSN numbers and saves it as a txt file
        quickSort();    //Calls quickSort() method that is called to sort the SSN numbers using the quick sort sorting algorithm
        radixSort();    //Calls radixSort() method that is called to sort the SSN numbers using the radix sort sorting algorithm
        bucketSort();   //Calls bucketSort() method that is called to sort the SSN numbers using the bucket sort sorting algorithm
    }

    /**
     * quickSort method that sorts all the generated SSN numbers using quickSort
     * @throws IOException
     */
    public static void quickSort() throws IOException{
        QuickSort sort = new QuickSort(); //Creates an instance of class QuickSort
        ArrayList<Integer> A = new ArrayList<>(read()); //Creates an ArrayList A that contains SSN numbers that were obtained from the text files using read() method
        sort.quickSort(A, 0, 299); // Calling quickSort() method from quickSort class using the created instance
        location(A, "Quick_SSN.txt"); //Saves the sorted numbers in a new txt file.
    }

    /**
     * radixSort method that is called to sort the SSN numbers using the radix sort sorting algorithm
     * @throws IOException
     */
    public static void radixSort() throws IOException{
        RadixSort sort = new RadixSort(); //Creates an instance of class RadixSort
        ArrayList<Integer> A = new ArrayList<>(read()); //Creates an ArrayList A that contains SSN numbers that were obtained from the text files using read() method
        sort.radixSort(A, A.size()); // Calling radixSort() method from radixSort class using the created instance
        location(A, "Radix_SSN.txt"); //Saves the sorted numbers in a new txt file.
    }

    /**
     * bucketSort method that is called to sort the SSN numbers using the radix sort sorting algorithm
     * @throws IOException
     */
    public static void bucketSort() throws IOException{
        BucketSort sort = new BucketSort(); //Creates an instance of class bucketSort
        ArrayList<Integer> A = new ArrayList<>(read()); //Creates an ArrayList A that contains SSN numbers that were obtained from the text files using read() method
        sort.bucketSort(A,0, 9); // Calling bucketSort() method from bucketSort class using the created instance
        location(A, "Bucket_SSN.txt"); //Saves the sorted numbers in a new txt file.
    }

    /**
     * This class creates a txt file for the sorted numbers, and assigns people location based on their SSN number in the sorted file.
     * @param A
     * @throws IOException
     */
    public static void location(ArrayList<Integer> A, String fileName) throws IOException {
        try(FileWriter txt = new FileWriter(fileName)) {
            //Count to store the number of SSNs in the area.
            int northEast = 0;
            int southEast = 0;
            int middleState = 0;
            int northWest = 0;
            int west = 0;
            //Loop through every area number to assign the location, and find the ratio of people in the areas.
            for (int i = 0; i < 300; i++) {
                String formattedSort = String.format("%09d", A.get(i)); //Padding with zeroes
                formattedSort = formattedSort.substring(0, 3) + "-" + formattedSort.substring(3, 5) + "-" + formattedSort.substring(5, 9); //Place them as per the requirement and according to the SSN requirements
                String areaNumber = formattedSort.substring(0, 3); //Takes just the area number for assigning locations
                int area = Integer.parseInt(areaNumber); //Parses the String to Integer for comparison
                //Assigns the area based on area number
                if (area < 200) {
                    northEast++;
                } else if (area >= 200 && area < 400) {
                    southEast++;
                } else if (area >= 400 && area < 600) {
                    middleState++;
                } else if (area >= 600 && area < 800) {
                    northWest++;
                } else {
                    west++;
                }
                txt.write(formattedSort); //Sorted list to the txt file
                txt.write(System.lineSeparator()); //Prints them on separate lines for better readability
            }
            txt.write("Northeast Coast States: " + northEast + " people");
            txt.write(System.lineSeparator());
            txt.write("SouthEast Coast States: " + southEast + " people");
            txt.write(System.lineSeparator());
            txt.write("Middle States: " + middleState + " people");
            txt.write(System.lineSeparator());
            txt.write("NorthWest Coast States: " + northWest + " people");
            txt.write(System.lineSeparator());
            txt.write("West Coast States: " + west + " people");
        }
    }
    /**
     * Writes the generated SSN numbers to text files
     * @throws IOException
     */
    public static void write() throws IOException{
        NumberGenerator number = new NumberGenerator(); //Creates an instance of class NumberGenerator
        //Creates a new txt file, calls NumberGenerator methods to generate numbers and stores them in the txt file
        try(FileWriter txt = new FileWriter("Random_SSN.txt")) {
            for (int i = 0; i < 300; i++) {
                String SSN = number.getAreaNumber() + "-" + number.getGroupNumber() + "-" + number.getSerialNumber();
                txt.write(SSN);
                txt.write(System.lineSeparator());
            }
        }
    }

    /**
     * Reads the generated SSN txt files and parses them to integer for sorting purpose
     * @return
     * @throws IOException
     */
    public static ArrayList<Integer> read() throws IOException{
        ArrayList<Integer> SSN = new ArrayList<>(); //Creates a new Integer ArrayList to store the string of SSNs from the txt file
        //Reads the txt file from the created txt file using write() method.
        try(Scanner read = new Scanner(new FileReader("Random_SSN.txt"))){
            while(read.hasNext()){
                String s = read.nextLine();
                s = s.substring(0,3) + s.substring(4,6) + s.substring(7,11);
                SSN.add(Integer.parseInt(s));
            }
        }
        return SSN; //Returns the ArrayList of integer SSNs
    }


}
