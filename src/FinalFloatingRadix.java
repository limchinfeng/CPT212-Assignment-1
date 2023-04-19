import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FinalFloatingRadix {

    public static float[] IntegerRadixsort(float[] arr) {
        int arraySize = arr.length;
        float maxValue = getMaxValue(arr);
        double exp = 0.00000000000000001;

        List<Float>[] array1 = createArrayLists();
        List<Float>[] array2 = createArrayLists();

        for (int count1 = 0; count1 < arraySize; count1++) {
            int index = (int) ((arr[count1] * exp) % 10);
            float value = arr[count1];
            array1[index].add(value);
        }

        exp *= 10;

        while (maxValue / exp > 0) {

            for (int count = 0; count < 10; count++) {
                while (!array1[count].isEmpty()) {
                    float arrValue = array1[count].remove(0);
                    int index1 = (int) ((arrValue / exp) % 10);
                    array2[index1].add(arrValue);
                }
            }
            exp *= 10;
            for (int count = 0; count < 10; count++) {
                while (!array2[count].isEmpty()) {
                    float arrValue2 = array2[count].remove(0);
                    int index2 = (int) ((arrValue2 / exp) % 10);
                    array1[index2].add(arrValue2);
                }
            }
            exp *= 10;
        }
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

    private static float getMaxValue(float[] arr) {
        float maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }
        return maxValue;
    }

    private static List<Float>[] createArrayLists() {
        List<Float>[] arrays = new ArrayList[10];
        for (int i = 0; i < 10; i++) {
            arrays[i] = new ArrayList<>();
        }
        return arrays;
    }

    static void print(float arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        float[] arr = { 0.0000014f, 0.0000013f, 0.00008f, 2.56707f, 0.2403f, 1.102f, 0.606f, 0.000016f, 0.304f,
                0.000015f, 0.807f,
                0.707f, 0.506f, 0.809f, 101.809f, 100.809f };
        System.out.print("Original Array: ");
        print(arr);
        float[] sortedArr = IntegerRadixsort(arr);
        System.out.print("Sorted Array: ");
        print(sortedArr);
    }
}
