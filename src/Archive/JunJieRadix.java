package Archive;
import java.util.ArrayList;
import java.util.Arrays;

public class JunJieRadix {

    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void radixSort(int[] arr) {

        int array_size = arr.length;
        int max_value = getMax(arr);
        int exp = 1;

        ArrayList<Integer>[] array1 = new ArrayList[10];
        ArrayList<Integer>[] array2 = new ArrayList[10];

        for (int i = 0; i < 10; i++) {
            array1[i] = new ArrayList<>();
            array2[i] = new ArrayList<>();
        }

        for (int count1 = 0; count1 < array_size; count1++) {
            int index = (arr[count1] / exp) % 10;
            int value = arr[count1];
            array1[index].add(value);
        }

        exp *= 10;

        while (max_value / exp > 0) {

            for (int count = 0; count < 10; count++) {
                while (!array1[count].isEmpty()) {
                    int arr_value = 0;
                    arr_value = array1[count].remove(0);
                    int index1 = (arr_value / exp) % 10;
                    array2[index1].add(arr_value);
                }
            }
            exp *= 10;
            for (int count = 0; count < 10; count++) {
                while (!array2[count].isEmpty()) {
                    int arr_value2 = 0;
                    arr_value2 = array2[count].remove(0);
                    int index2 = ((arr_value2 / exp) % 10);
                    array1[index2].add(arr_value2);

                }
            }
            exp *= 10;

        }
        int arr_count = 0;
        for (int count = 0; count < 10; count++) {
            while (!array1[count].isEmpty()) {
                int arr_value3 = array1[count].remove(0);
                arr[arr_count] = arr_value3;
                arr_count++;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = { 275, 8, 46, 61, 409, 1700, 677, 503 };
        System.out.println("Original Array: " + Arrays.toString(arr));
        radixSort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

}