import java.util.HashSet;

public class FindRepeated {
    public static void main(String[] args) {
        int[] A = {1, 3, 4, 2, 5, 3};

        int repeated = findRepeated(A);
        System.out.println("The repeated integer is: " + repeated);
    }

    public static int findRepeated(int[] array) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : array) {
            if (seen.contains(num)) {
                return num;
            }
            seen.add(num);
        }
        return -1;
    }
}
