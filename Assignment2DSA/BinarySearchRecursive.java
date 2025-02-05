class BinarySearchRecursive {
    public static int binarySearch(int[] arr, int low, int high, int target) {
        if (low > high) return -1; // Base case: not found

        int mid = low + (high - low) / 2;

        if (arr[mid] == target) return mid; // Found
        else if (arr[mid] < target) return binarySearch(arr, mid + 1, high, target); // Right half
        else return binarySearch(arr, low, mid - 1, target); // Left half
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 15};
        int target = 9;

        int index = binarySearch(sortedArray, 0, sortedArray.length - 1, target);
        System.out.println("Element found at index: " + index); // Output: 4
    }
}
