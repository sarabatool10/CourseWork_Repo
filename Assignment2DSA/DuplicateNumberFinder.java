class DuplicateNumberFinder {
    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // Phase 1: Detect cycle
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Find entrance of the cycle (duplicate number)
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow; // Duplicate number
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 4, 2}; // Example input
        System.out.println("Duplicate number: " + findDuplicate(nums)); // Output: 3
    }
}
