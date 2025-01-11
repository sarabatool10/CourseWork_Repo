
import java.util.Arrays;

public class ArrayDeletion {
    public static void main(String[] args) {
        // Original array
        int[] arr = {10, 20, 30, 40, 50};

        // Index to delete
        int index = 2;

        // Attempt to delete the element at the specified index
        int[] result = deleteAtIndex(arr, index);

        // Print the array after deletion
        if (result != null) {
            System.out.println("Array after deletion: " + Arrays.toString(result));
        }
    }

    public static int[] deleteAtIndex(int[] arr, int index) {
        // Check if the index is within bounds
        if (index < 0 || index >= arr.length) {
            System.out.println("Error: Index out of bounds.");
            return null; // Return null to indicate failure
        }

        // Create a new array with length one less than the original array
        int[] newArr = new int[arr.length - 1];

        // Copy elements before the index to the new array
        for (int i = 0; i < index; i++) {
            newArr[i] = arr[i];
        }

        // Copy elements after the index to the new array
        for (int i = index + 1; i < arr.length; i++) {
            newArr[i - 1] = arr[i];
        }

        // Return the new array
        return newArr;
    }
}
