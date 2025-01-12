import java.util.Arrays;

public class AddOneToArray {
    public static int[] addOne(int[] digits) {
        int n = digits.length;

        // Traverse the array from the last digit
        for (int i = n - 1; i >= 0; i--) {
            // If the digit is less than 9, just add 1 and return the result
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // If the digit is 9, set it to 0 and continue the loop
            digits[i] = 0;
        }

        // If we reach here, it means all digits were 9
        // Create a new array with an extra space for the carry
        int[] result = new int[n + 1];
        result[0] = 1; // Set the most significant digit to 1
        // Remaining digits are already initialized to 0
        return result;
    }

    public static void main(String[] args) {
        // Test Cases
        int[] digits1 = {1, 2, 3};
        int[] result1 = addOne(digits1);
        System.out.println("Input: " + Arrays.toString(digits1) + " Output: " + Arrays.toString(result1));

        int[] digits2 = {9, 9, 9};
        int[] result2 = addOne(digits2);
        System.out.println("Input: " + Arrays.toString(digits2) + " Output: " + Arrays.toString(result2));

        int[] digits3 = {0};
        int[] result3 = addOne(digits3);
        System.out.println("Input: " + Arrays.toString(digits3) + " Output: " + Arrays.toString(result3));
    }
}
