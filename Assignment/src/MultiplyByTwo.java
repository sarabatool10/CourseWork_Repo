import java.util.Arrays;

public class MultiplyByTwo {
    public static int[] multiplyByTwo(int[] digits) {
        int n = digits.length;
        int carry = 0;

        // Create an array to store the result (same size as digits, extra space if carry overflows)
        int[] result = new int[n + 1];

        // Traverse the array from the last digit
        for (int i = n - 1; i >= 0; i--) {
            int product = digits[i] * 2 + carry; // Multiply by 2 and add carry
            result[i + 1] = product % 10;       // Store the current digit
            carry = product / 10;              // Update the carry
        }

        // If there's a carry left, store it in the first position
        if (carry > 0) {
            result[0] = carry;
            return result; // Return the full array (including carry)
        }

        // If no carry is left, return the array excluding the first element
        return Arrays.copyOfRange(result, 1, result.length);
    }

    public static void main(String[] args) {
        // Test Cases
        int[] digits1 = {1, 2, 3};
        int[] result1 = multiplyByTwo(digits1);
        System.out.println("Input: " + Arrays.toString(digits1) + " Output: " + Arrays.toString(result1));

        int[] digits2 = {9, 9, 9};
        int[] result2 = multiplyByTwo(digits2);
        System.out.println("Input: " + Arrays.toString(digits2) + " Output: " + Arrays.toString(result2));

        int[] digits3 = {0};
        int[] result3 = multiplyByTwo(digits3);
        System.out.println("Input: " + Arrays.toString(digits3) + " Output: " + Arrays.toString(result3));
    }
}
