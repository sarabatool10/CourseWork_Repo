import java.util.Stack;

public class BalancedParentheses {
    public static void main(String[] args) {
        String expression = "{[()]}";
        boolean isBalanced = isBalanced(expression);
        System.out.println("Is the expression balanced? " + isBalanced); // Output: true
    }

    public static boolean isBalanced(String expr) {
        Stack<Character> stack = new Stack<>();
        for (char ch : expr.toCharArray()) {
            // Push opening brackets to stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // Check for matching closing brackets
            else if (ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (ch == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (ch == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                return false; // Return false if no match is found
            }
        }
        // If stack is empty, the expression is balanced
        return stack.isEmpty();
    }
}
