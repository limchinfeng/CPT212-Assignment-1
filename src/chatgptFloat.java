import java.util.*;

public class chatgptFloat {

    // A utility function to get the maximum value in arr[]
    static float getMax(float arr[], int n) {
        float mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    // A function to do counting sort of arr[] according to the digit represented by exp
    static void countSort(float arr[], int n, int exp) {
        List<List<Float>> buckets = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayList<>());
        }

        // Place each number in the appropriate bucket based on its current digit
        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) ((arr[i] / exp) % 10);
            buckets.get(bucketIndex).add(arr[i]);
        }

        // Concatenate the numbers in each bucket to obtain the sorted array
        int index = 0;
        for (int i = 0; i < 10; i++) {
            for (float num : buckets.get(i)) {
                arr[index++] = num;
            }
        }
    }

    // The main function to that sorts arr[] of size n using Radix Sort
    static void radixsort(float arr[], int n) {
        // Find the maximum number to know number of digits
        float m = getMax(arr, n);

        // Do counting sort for every digit
        for (int exp = 1; m / exp > 0; exp *= 10) {
            countSort(arr, n, exp);
        }
    }

    // A utility function to print an array
    static void print(float arr[], int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver function to test above functions
    public static void main(String args[]) {
        float arr[] = {0.45f, 0.12f, 0.67f, 0.33f, 0.89f, 0.51f};
        int n = arr.length;

        System.out.println("Input array: " + Arrays.toString(arr));
        radixsort(arr, n);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
