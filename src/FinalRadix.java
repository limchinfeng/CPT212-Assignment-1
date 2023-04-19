import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FinalRadix {

    public static int[] IntegerRadixsort(int[] arr) {
        // Get the size of the input arrau
        int arraySize = arr.length;
        // Find the maximum value in the input array
        int maxValue = getMaxValue(arr);
        // Set the starting value for the exponent

        int exp = 1;

        // Create two arrays of ArrayLists to store the integers
        List<Integer>[] array1 = createArrayLists();
        List<Integer>[] array2 = createArrayLists();

        // Sort the input array by the least significant digit
        for (int count1 = 0; count1 < arraySize; count1++) {
            int index = (arr[count1] / exp) % 10;
            int value = arr[count1];
            array1[index].add(value);
        }

        // Update the exponent to the next significant digit
        exp *= 10;

        // Repeat the process until all significant digits have been sorted
        while (maxValue / exp > 0) {

            // Move the values from array1 to array2, sorted by the next significant digit
            for (int count = 0; count < 10; count++) {
                while (!array1[count].isEmpty()) {
                    int arrValue = array1[count].remove(0);
                    int index1 = (arrValue / exp) % 10;
                    array2[index1].add(arrValue);
                }
            }
            // Update the exponent to the next significant digit
            exp *= 10;
            // Move the values from array2 to array1, sorted by the next significant digit
            for (int count = 0; count < 10; count++) {
                while (!array2[count].isEmpty()) {
                    int arrValue2 = array2[count].remove(0);
                    int index2 = ((arrValue2 / exp) % 10);
                    array1[index2].add(arrValue2);
                }
            }
            exp *= 10;
        }
        // Create a sorted array from the values in array1
        int[] sortedArray = new int[arraySize];
        int arrCount = 0;
        for (int count = 0; count < 10; count++) {
            while (!array1[count].isEmpty()) {
                int arrValue3 = array1[count].remove(0);
                sortedArray[arrCount] = arrValue3;
                arrCount++;
            }
        }
        return sortedArray;
    }

    // A method that finds the maximum value in an array of integers
    private static int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }
        return maxValue;
    }

    private static List<Integer>[] createArrayLists() {
        List<Integer>[] arrays = new ArrayList[10];
        for (int i = 0; i < 10; i++) {
            arrays[i] = new ArrayList<>();
        }
        return arrays;
    }

    // A method that prints an array of integers
    static void print(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // The main method
    public static void main(String[] args) {
        // Create an unsorted array of Integer
        int[] arr = { 170, 61, 503, 275, 426, 87, 677, 409 };
        System.out.print("Original Array: ");
        print(arr);
        // Sort the array using Integer Radix Sort algorithm and store the sorted array
        // in sortedArr
        int[] sortedArr = IntegerRadixsort(arr);
        System.out.print("Sorted Array: ");
        print(sortedArr);
    }
}
