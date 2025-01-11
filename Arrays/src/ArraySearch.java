public class ArraySearch {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int value = 30;

        int index = findIndex(arr, value);

        if (index != -1) {
            System.out.println("Value " + value + " found at index: " + index);
        } else {
            System.out.println("Value " + value + " not found in the array.");
        }
    }

    public static int findIndex(int[] arr, int value) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
