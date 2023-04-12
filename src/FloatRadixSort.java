// Archive (from ChatGPT but can't sort properly

import java.util.*;

class FloatRadixSort {

    // A utility function to get the fractional part of a float
    static double getFraction(float num) {
        return num - Math.floor(num);
    }

    // A function to do counting sort of arr[] according to
    // the fractional part represented by exp.
    static void countSort(float arr[], int n, double exp)
    {
        float output[] = new float[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[(int)((arr[i] / exp) % 10)]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array using a stable sorting algorithm
        for (i = n - 1; i >= 0; i--) {
            output[count[(int)((arr[i] / exp) % 10)] - 1] = arr[i];
            count[(int)((arr[i] / exp) % 10)]--;
        }
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    // The main function to that sorts arr[] of
    // size n using Radix Sort
    static void radixsort(float arr[], int n) {

        // Do counting sort for every fractional part. Note that
        // instead of passing the digit number, exp is passed.
        // exp is 10^-i where i is current fractional part number
        for (double exp = 0.1; exp >= 1.0e-8; exp *= 0.1) {
            countSort(arr, n, exp);
        }
    }

    // A utility function to print an array
    static void print(float arr[], int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Main driver method
    public static void main(String[] args) {
        float arr[] = { 0.897f, 2.565f, 0.656f, 0.123f, 0.665f, 0.343f, 0.001f, 0.002f, 0.655f,0.564f, 0.896f };
        int n = arr.length;

        // Function Call
        radixsort(arr, n);
        print(arr, n);
    }
}