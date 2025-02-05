public class FindDuplicates {
    public static int findDuplicate(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int expectedSum = (n - 1) * (n - 2) / 2; // Sum of first n-1 natural numbers

        for (int num : nums) {
            sum += num;
        }

        return sum - expectedSum;
    }

    public static void main(String[] args) {
        int[] arr = {0, 2, 3, 1, 4, 5, 3}; // Example array
        int duplicate = findDuplicate(arr);
        System.out.println("Duplicate number is: " + duplicate); // Output: 3
    }
}
