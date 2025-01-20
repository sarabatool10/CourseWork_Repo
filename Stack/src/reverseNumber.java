import java.util.Stack;

class ReverseNumber {

    // Reverse a number using stack
    public static int reverseNumber(int num) {
        Stack<Integer> stack = new Stack<>();

        // Push the digits of the number onto the stack
        while (num != 0) {
            stack.push(num % 10);
            num /= 10;
        }

        // Reconstruct the number from the stack
        int reversed = 0;
        int place = 1;
        while (!stack.isEmpty()) {
            reversed += stack.pop() * place;
            place *= 10;
        }
        return reversed;
    }

    public static void main(String[] args) {
        int input = 12345;
        System.out.println("Reversed number: " + reverseNumber(input)); // Output: 54321
    }
}
