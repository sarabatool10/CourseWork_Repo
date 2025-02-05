import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static List<Integer> getRow(int n) {
        List<Integer> row = new ArrayList<>();
        long value = 1;
        row.add((int) value);

        for (int k = 1; k <= n; k++) {
            value = value * (n - k + 1) / k;
            row.add((int) value);
        }

        return row;
    }

    public static void main(String[] args) {
        int n = 4; // Example row number
        List<Integer> row = getRow(n);
        System.out.println("Row " + n + " of Pascal's Triangle: " + row);
    }
}
