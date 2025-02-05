import java.util.HashSet;
import java.util.Set;

public class FindDuplicate {
    public static int findDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (!seen.add(num)) {
                return num; // Found the duplicate number
            }
        }
        return -1; // If no duplicate is found
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 5, 3}; // Example array with a duplicate
        int duplicate = findDuplicate(nums);
        if (duplicate != -1) {
            System.out.println("Duplicate number found: " + duplicate);
        } else {
            System.out.println("No duplicate number found.");
        }
    }
}
