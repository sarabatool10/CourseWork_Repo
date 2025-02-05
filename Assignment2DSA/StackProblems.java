class Node {
    int data;
    Node next;

    Node(int v) {
        data = v;
        next = null;
    }
}

class SLL {
    Node head;

    public SLL() {
        head = null;
    }

    public void prepend(int v) {
        Node n = new Node(v);
        n.next = head;
        head = n;
    }

    public void print() {
        Node c = head;
        while (c != null) {
            System.out.println(c.data);
            c = c.next;
        }
    }
}

class MyStack { // Renamed to avoid conflict
    private SLL sll;
    private int count;

    public MyStack() {
        sll = new SLL();
        count = 0;
    }

    public void push(int v) {
        sll.prepend(v);
        count++;
    }

    public Integer pop() {
        if (count == 0) return null; // Prevent null pointer exception

        Node result = sll.head;
        sll.head = sll.head.next;
        count--;
        return result.data;
    }

    public Integer top() {
        if (count == 0) return null;
        return sll.head.data;
    }

    public int size() {
        return count;
    }

    public void display() {
        sll.print();
    }
}

public class StackProblems {
    public static boolean checkEq(String str1) {
        MyStack s = new MyStack();
        char[] st = str1.toCharArray();
        
        for (char ch : st) {
            if (ch == '(') {
                s.push((int) ch);
            } else if (ch == ')') {
                if (s.pop() == null) { // If stack is empty, parentheses are unbalanced
                    return false;
                }
            }
        }
        return s.size() == 0;
    }

    public static void revP(String[] arr) {
        MyStack s = new MyStack();
        
        for (String ele : arr) {
            if (ele.equals("*") || ele.equals("/") || ele.equals("+") || ele.equals("-")) {
                int v1 = s.pop();
                int v2 = s.pop();
                int v3 = eval(v2, ele, v1); // Corrected order
                s.push(v3);
            } else {
                s.push(Integer.parseInt(ele));
            }
        }
        System.out.println("Result: " + s.pop());
    }

    private static int eval(int v1, String op, int v2) {
        switch (op) {
            case "*": return v1 * v2;
            case "/": return v1 / v2;
            case "+": return v1 + v2;
            case "-": return v1 - v2;
            default: throw new IllegalArgumentException("Invalid operator: " + op);
        }
    }

    public static void main(String[] args) {
        System.out.println("Parentheses Balanced? " + checkEq(")((4+1)(a+b))"));

        revP(new String[]{"2", "3", "1", "+", "4", "*", "-"}); // Postfix evaluation
    }
}
