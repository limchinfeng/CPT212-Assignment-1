import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FinalFloatingRadix {

    public static float[] IntegerRadixsort(float[] arr) {
        int arraySize = arr.length;
        float maxValue = getMaxValue(arr);
        // Initialize the exponent to be a very small value
        double exp = 0.000000000001;

        // Create two arrays of ArrayLists to hold the values of the input array during
        // sorting.
        // Each ArrayList in the arrays will hold the values with a particular radix
        // during a pass.
        List<Float>[] array1 = createArrayLists();
        List<Float>[] array2 = createArrayLists();

        // First pass: Sort the values of the input array based on their least
        // significant radix (the digit
        // to the right of the decimal point) and add them to the corresponding
        // ArrayList in array1.
        for (int count1 = 0; count1 < arraySize; count1++) {
            int index = (int) ((arr[count1] * exp) % 10);
            float value = arr[count1];
            array1[index].add(value);
        }

        // Multiply the radix by 10 to move to the next digit to the left of the decimal
        // point.
        exp *= 10;

        // Continue the sorting process until all digits have been sorted.
        while (maxValue / exp > 0) {

            // For each pass, empty each ArrayList in array1 into the appropriate ArrayList
            // in array2
            // based on the next digit to the left of the decimal point.
            for (int count = 0; count < 10; count++) {
                while (!array1[count].isEmpty()) {
                    float arrValue = array1[count].remove(0);
                    int index1 = (int) ((arrValue / exp) % 10);
                    array2[index1].add(arrValue);
                }
            }
            // Multiply the radix by 10 to move to the next digit to the left of the decimal
            // point.
            exp *= 10;

            // For each pass, empty each ArrayList in array2 into the appropriate ArrayList
            // in array1
            // based on the next digit to the left of the decimal point.
            for (int count = 0; count < 10; count++) {
                while (!array2[count].isEmpty()) {
                    float arrValue2 = array2[count].remove(0);
                    int index2 = (int) ((arrValue2 / exp) % 10);
                    array1[index2].add(arrValue2);
                }
            }
            // Multiply the radix by 10 to move to the next digit to the left of the decimal
            // point.
            exp *= 10;
        }

        // Copy the sorted values from array1 into a new float array and return it.
        float[] sortedArray = new float[arraySize];
        int arrCount = 0;
        for (int count = 0; count < 10; count++) {
            while (!array1[count].isEmpty()) {
                float arrValue3 = array1[count].remove(0);
                sortedArray[arrCount] = arrValue3;
                arrCount++;
            }
        }
        return sortedArray;
    }

    // Helper function to find the maximum value in an array of floats.
    private static float getMaxValue(float[] arr) {
        float maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }
        return maxValue;
    }

    // This method creates an array of 10 empty ArrayLists of Float
    private static List<Float>[] createArrayLists() {
        List<Float>[] arrays = new ArrayList[10];
        for (int i = 0; i < 10; i++) {
            arrays[i] = new ArrayList<>();
        }
        return arrays;
    }

    // This method prints the elements of an array of floats
    static void print(float arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // This is the main method where the program starts executing
    public static void main(String[] args) {
        // Create an unsorted array of floats
        float[] arr = { 0.0014f, 0.0013f, 0.008f, 2.56707f, 0.2403f, 1.102f, 0.606f, 0.016f, 0.304f, 0.807f, 0.707f,
                0.506f, 0.809f, 101.809f, 100.809f };
        System.out.print("Original Array: ");
        print(arr);
        // Sort the array using Integer Radix Sort algorithm and store the sorted array
        // in sortedArr
        float[] sortedArr = IntegerRadixsort(arr);
        System.out.print("Sorted Array: ");
        print(sortedArr);
    }
}
