import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FinalRadix {

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
        }

        exp *= 10;

        while (maxValue / exp > 0) {

            for (int count = 0; count < 10; count++) {
                while (!array1[count].isEmpty()) {
                    int arrValue = array1[count].remove(0);
                    int index1 = (arrValue / exp) % 10;
                    array2[index1].add(arrValue);
                }
            }
            exp *= 10;
            for (int count = 0; count < 10; count++) {
                while (!array2[count].isEmpty()) {
                    int arrValue2 = array2[count].remove(0);
                    int index2 = ((arrValue2 / exp) % 10);
                    array1[index2].add(arrValue2);
                }
            }
            exp *= 10;
        }
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

    static void print(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 170, 61, 503, 275, 426, 87, 677, 409 };
        System.out.print("Original Array: ");
        print(arr);
        int[] sortedArr = IntegerRadixsort(arr);
        System.out.print("Sorted Array: ");
        print(sortedArr);
    }
}
