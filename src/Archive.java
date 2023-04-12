import java.util.*;

class testssing {

    // A utility function to get maximum value in arr[]
    static float getMax(float arr[], int n)
    {
        float mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(float arr[], int n, double exp)
    {
        float output[] = new float[n]; // output array
        int i;
        int count[] = new int[20]; // count array for decimal values
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[(int)((arr[i] / exp) % 10) + 10]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 20; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[(int)((arr[i] / exp) % 10) + 10] - 1] = arr[i];
            count[(int)((arr[i] / exp) % 10) + 10]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current
        // digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    // The main function to that sorts arr[] of
    // size n using Radix Sort
    static void radixsort(float arr[], int n)
    {
        // Find the maximum number to know number of digits
        float m = getMax(arr, n);

        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number
        for (double exp = 0.1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

    // A utility function to print an array
    static void print(float arr[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Main driver method
    public static void main(String[] args)
    {
        float arr[] = { 0.0897f, 2.565f, 0.00656f, 0.123f, 0.665f, 0.343f, 0.001f, 0.002f, 0.655f,0.564f, 0.896f };
        int n = arr.length;

        // Function Call
        radixsort(arr, n);
        print(arr, n);
    }
}
