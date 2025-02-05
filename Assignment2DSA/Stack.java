import java.util.Arrays;

public class Stack {
    private int[] array;
    private int index;

    public Stack(int length) {
        array = new int[length];
        index = 0;
    }

    public void push(int v) {
        if (index < array.length) {
            array[index] = v;
            index++;
        } else {
            cloneArrayWithDoubleSize();
            array[index] = v;
            index++;
        }
    }

    private void cloneArrayWithDoubleSize() {
        // Creating new array with double the size of the original array
        int[] newArray = new int[2 * array.length];
        // Copying elements from the original array to the new array
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public int pop() {
        int result = array[index - 1];
        index--;
        return result;
    }

    public int size() {
        // Returns the current size of the stack
        return index;
    }

    public int top() {
        // Returns the top element of the stack without removing it
        return array[index - 1];
    }

    public boolean isEmpty() {
        // Checks if the stack is empty
        return index == 0;
    }

    public void print() {
        // Prints the current state of the stack
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        Stack s = new Stack(4);
        s.push(5);
        s.push(8);
        s.push(9);
        s.push(10);
        s.push(30);
        s.print(); // Output the current state of the array
    }
}
