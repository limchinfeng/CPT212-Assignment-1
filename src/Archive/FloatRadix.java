package Archive;
import java.util.*;

class FloatRadix {

    // A utility function to get maximum value in arr[]
    static float getMax(float arr[], int n) {
        float mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(float arr[], int n, double exp) {
        float output[] = new float[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        // **Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[(int) ((arr[i] / exp) % 10)]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // **Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[(int) ((arr[i] / exp) % 10)] - 1] = arr[i];
            count[(int) ((arr[i] / exp) % 10)]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current
        // digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];

        // print(arr, n);
    }

    // The main function to that sorts arr[] of
    // **size n using Radix Sort
    static void radixsort(float arr[], int n) {
        // Find the maximum number to know number of digits
        float m = getMax(arr, n);
        // System.out.println(m);

        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // **exp is 10^i where i is current digit number
        for (double exp = 0.001; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

    // A utility function to print an array
    static void print(float arr[], int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Main driver method
    public static void main(String[] args) {
        float arr[] = { 0.007f, 2.507f, 0.203f, 0.102f, 0.606f, 0.304f, 0.015f, 0.807f, 0.707f, 0.506f, 0.809f };
        int n = arr.length;

        // Function Call
        radixsort(arr, n);
        print(arr, n);
    }
}