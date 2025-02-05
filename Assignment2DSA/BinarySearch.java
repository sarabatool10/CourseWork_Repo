public class BinarySearch {
    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2; // To avoid potential overflow
            
            if (nums[mid] == target) {
                return mid; // Target found
            }
            if (nums[mid] < target) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 11}; // Example sorted array
        int target = 7; // Example target value
        
        int result = binarySearch(nums, target);
        if (result != -1) {
            System.out.println("Target value found at index: " + result);
        } else {
            System.out.println("Target value not found in the array.");
        }
    }
}
