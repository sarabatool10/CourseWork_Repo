import java.util.Stack;

class ReverseString {

    // Reverse a string using stack
    public static String reverseString(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        String input = "hello";
        System.out.println("Reversed string: " + reverseString(input)); // Output: "olleh"
    }
}
