package V2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CounterInteger {
    // initialize the counter to 0
    static int counter = 0;

    public static int[] IntegerRadixsort(int[] arr) {

        int arraySize = arr.length;
        int maxValue = getMaxValue(arr);
        int exp = 1;
        List<Integer>[] array1 = createArrayLists();
        List<Integer>[] array2 = createArrayLists();

        for (int count1 = 0; count1 < arraySize; count1++) {
            int index = (arr[count1] / exp) % 10;
            int value = arr[count1];
            array1[index].add(value);
            counter += 4; // 1 division, 1 modulo, 1 array access, 1 value assignment
        }

        exp *= 10;

        while (maxValue / exp > 0) {
            for (int count = 0; count < 10; count++) {
                while (!array1[count].isEmpty()) {
                    int arrValue = array1[count].remove(0);
                    int index1 = (arrValue / exp) % 10;
                    array2[index1].add(arrValue);
                    counter += 6; // 1 division, 1 modulo, 1 array access, 1 remove operation, 1 value assignment,
                                  // 1 add operation
                }
                counter += 2; // 1 while loop, 1 array access
            }

            exp *= 10;

            for (int count = 0; count < 10; count++) {
                while (!array2[count].isEmpty()) {
                    int arrValue2 = array2[count].remove(0);
                    int index2 = ((arrValue2 / exp) % 10);
                    array1[index2].add(arrValue2);
                    counter += 6; // 1 division, 1 modulo, 1 array access, 1 remove operation, 1 value assignment,
                                  // 1 add operation
                }
                counter += 2; // 1 while loop, 1 array access
            }
            exp *= 10;
            counter += 2; // 1 multiplication, 1 comparison
        }

        int[] sortedArray = new int[arraySize];
        int arrCount = 0;
        for (int count = 0; count < 10; count++) {
            while (!array1[count].isEmpty()) {
                int arrValue3 = array1[count].remove(0);
                sortedArray[arrCount] = arrValue3;
                arrCount++;
                counter += 4; // 1 remove operation, 1 array access, 1 value assignment, 1 increment operation
            }
            counter += 2; // 1 while loop, 1 array access
        }
        counter++; // 1 return operation
        System.out.println("Number of primitive calculations: " + counter);
        return sortedArray;
    }

    private static int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
                counter += 2; // 1 comparison, 1 value assignment
            }
            counter += 2; // 1 comparison, 1 increment operation
        }
        counter++; // 1 return operation
        return maxValue;
    }

    private static List<Integer>[] createArrayLists() {
        List<Integer>[] arrays = new ArrayList[10];
        counter += 3;
        for (int i = 0; i < 10; i++) {
            arrays[i] = new ArrayList<>();
            counter += 5; // increment counter for each new ArrayList created
        }
        counter++; // 1 return operation
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
        // int[] arr = { 170, 61, 503, 275, 426, 87, 677 };
        // int[] arr = { 170, 61, 503, 275, 426, 87};
        // int[] arr = { 170, 61, 503, 275, 426 };
        // int[] arr = { 170, 61, 503, 275 };
        // int[] arr = { 170, 61, 503 };
        // int[] arr = { 170, 61 };
        // int[] arr = { 170 };
        System.out.print("Original Array: ");
        print(arr);
        // Sort the array using Integer Radix Sort algorithm and store the sorted array
        // in sortedArr
        int[] sortedArr = IntegerRadixsort(arr);
        System.out.print("Sorted Array: ");
        print(sortedArr);
    }
}