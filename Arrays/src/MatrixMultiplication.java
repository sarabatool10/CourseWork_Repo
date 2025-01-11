public class MatrixMultiplication {
    public static void main(String[] args) {
        int[][] A = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] B = {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        };

        int[][] C = multiplyMatrices(A, B);

        if (C != null) {
            System.out.println("Matrix C (A * B):");
            printMatrix(C);
        } else {
            System.out.println("Matrix dimensions are not compatible for multiplication.");
        }
    }

    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        if (A[0].length != B.length) {
            return null;
        }

        int n = A.length;
        int m = B[0].length;
        int p = A[0].length; // or B.length
        int[][] C = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < p; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return C;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
