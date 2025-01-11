
import java.util.Arrays;

public class ArrayInsertion {
    public static void main(String[] args) {
        // Original array
        int[] arr = {10, 20, 30, 40, 50};

        // Element to insert
        int elementToInsert = 25;

        // Index at which to insert the element
        int index = 2;

        // Inserting element at specified index
        arr = insertAtIndex(arr, elementToInsert, index);

        // Print the array after insertion
        System.out.println("Array after insertion: " + Arrays.toString(arr));
    }

    public static int[] insertAtIndex(int[] arr, int element, int index) {
        // Create a new array with length one greater than the original array
        int[] newArr = new int[arr.length + 1];

        // Copy elements before the insertion index
        for (int i = 0; i < index; i++) {
            newArr[i] = arr[i];
        }

        // Insert the new element at the specified index
        newArr[index] = element;

        // Copy the remaining elements after the insertion index
        for (int i = index; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }

        // Return the new array
        return newArr;
    }
}