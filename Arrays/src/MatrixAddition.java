public class MatrixAddition {
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

        int[][] C = addMatrices(A, B);

        if (C != null) {
            System.out.println("Matrix C (A + B):");
            printMatrix(C);
        } else {
            System.out.println("Matrix dimensions are not compatible for addition.");
        }
    }

    public static int[][] addMatrices(int[][] A, int[][] B) {
        if (A.length != B.length || A[0].length != B[0].length) {
            return null;
        }

        int n = A.length;
        int m = A[0].length;
        int[][] C = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                C[i][j] = A[i][j] + B[i][j];
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
