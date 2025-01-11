public class DiagonalSums {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Left Diagonal Sum: " + leftDiagonalSum(matrix));
        System.out.println("Right Diagonal Sum: " + rightDiagonalSum(matrix));
    }

    public static int leftDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    public static int rightDiagonalSum(int[][] matrix) {
        int sum = 0;
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            sum += matrix[i][n - 1 - i];
        }
        return sum;
    }
}
