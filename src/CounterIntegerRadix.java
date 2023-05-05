import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CounterIntegerRadix{

    static int counter=0;
    public static int[] IntegerRadixsort(int[] arr) {
        // Get the size of the input array
        int arrSize = arr.length;
        counter+=2;
        // Find the maximum value in the input array
        int maxValue = getMaxValue(arr);
        counter+=2;
        // Set the starting value for the exponent
        int exponent = 1;
        counter++;
        // Create two arrays of ArrayLists to hold the values of the input array during
        // sorting.
        // Each ArrayList in the arrays will hold the values with a particular radix
        // during a pass.
        List<Integer>[] Array1 = createArrayLists();
        counter+=2;
        List<Integer>[] Array2 = createArrayLists();
        counter+=2;

        // First pass: Sort the values of the input array based on their least significant digit
        // and add them to the corresponding ArrayList in array1.
        counter++;//i=0
        for (int i = 0; i < arrSize; i++) {
            int index = (arr[i] / exponent) % 10;
            int value = arr[i];
            Array1[index].add(value);
            counter+=11;
        }

        // Multiply the radix by 10 to move to the the next significant digit
        exponent *= 10;
        counter+=2;

        // Repeat the process until all significant digits have been sorted
        for (; maxValue / exponent > 0; exponent *= 10) {
            // For each pass, empty each ArrayList in array1 into the appropriate ArrayList in array2
            // based on the next significant digit

            counter++;// 1 value assignment i=0
            for (int i = 0; i < 10; i++) {
                counter++;// 1 value assignment j=0
                for (int j = 0; j < Array1[i].size(); j++) {
                    int Array1Value = Array1[i].get(j);
                    int index1 = (Array1Value / exponent) % 10;
                    Array2[index1].add(Array1Value);
                    counter+=13;
                }

                Array1[i].clear();
                counter+=5;
            }

            // Multiply the radix by 10 to move to the next significant digit
            exponent *= 10;
            counter+=2;
            // For each pass, empty each ArrayList in array2 into the appropriate ArrayList in array1
            // based on the next significant digit
            counter++;// 1 value assignment i=0
            for (int i = 0; i < 10; i++) {

                counter++;
                for (int j = 0; j < Array2[i].size(); j++) {
                    int Array2Value = Array2[i].get(j);
                    int index2 = ((Array2Value / exponent) % 10);
                    Array1[index2].add(Array2Value);
                    counter+=13;
                }
                Array2[i].clear();
                counter+=5;
            }
            counter+=4;
        }

        // Copy the sorted values from array1 into a new int array and return it.
        int[] sortedArray = new int[arrSize];
        counter+=2;

        int arrCount = 0;
        counter++;

        counter++;// 1 value assignment i=0
        for (int i = 0; i < 10; i++) {

            while (!Array1[i].isEmpty()) {
                int sortedArrayValue = Array1[i].remove(0);
                sortedArray[arrCount] = sortedArrayValue;
                arrCount++;
                counter+=8;
            }
            counter+=3;
        }
        counter++;
        return sortedArray;
    }

    // A method that finds the maximum value in an array of integers
    private static int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        counter+=2;

        counter++;// 1 value assignment i=1
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
                counter+=4;
            }
            counter+=4;
        }
        counter++;
        return maxValue;
    }

    // This method creates an array of 10 empty ArrayLists of Int
    private static List<Integer>[] createArrayLists() {
        List<Integer>[] arrays = new ArrayList[10];
        counter+=2;

        counter++;// 1 value assignment i=0
        for (int i = 0; i < 10; i++) {
            arrays[i] = new ArrayList<>();
            counter+=5;
        }

        counter++;
        return arrays;
    }

    // This method prints the elements of an array of integer
    static void print(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // This is the main method where the program starts executing
    public static void main(String[] args) {
        // Create an unsorted array of Integer
//        int[] arr = { 170, 61, 503, 275, 426, 87, 677, 409 };
//        System.out.print("Original Array: ");
//        print(arr);
//        // Sort the array using Integer Radix Sort algorithm and store the sorted array
//        // in sortedArr
//        int[] sortedArr = IntegerRadixsort(arr);
//        System.out.print("Sorted Array: ");
//        print(sortedArr);

        int [] n = {1,10,100,1000,10000,100000};

        for(int i=0; i<n.length; i++){

            int number = n[i];
            int ar[]=new int[number];

            for(int j=1; j<=n[i] ;j++){
                ar[j-1]=j;
//                System.out.print(ar[j-1]+" , ");
            }
            IntegerRadixsort(ar);
            System.out.println("n = "+n[i] +" , counter = "+counter);
            counter=0;
        }
    }
}
