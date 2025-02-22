package RotateImage;

/* Date: 2025-02-21
 * Problem Name: Rotate Image
 * Problem description: You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees. In Place. DO NOT
 * allocate another 2D Matrix and do the rotation.
 * Author: @Jgriff1995
 * Link: https://leetcode.com/problems/rotate-image/description/
 */

public class RotateImageSolution {

    /*
     * Rotate solution
     * Time Complexity: O(n²), Space Complexity: O(1)
     * Explanation: O(n²): We iterate through the matrix twice (once for transposing
     * and once for reversing rows).
     * O(1): We are modifying the matrix in place without using extra space or
     * allocating another 2D matrix.
     */
    public static void rotate(int[][] matrix) {
        // Transpose the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                // Swap matrix[i][j] with matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row
        for (int i = 0; i < matrix.length; i++) {
            int start = 0;
            int end = matrix.length - 1;
            while (start < end) {
                // Swap matrix[i][start] with matrix[i][end]
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        }
    }

    /*
     * Helper method to print the matrix in a visually appealing format.
     */
    public static void printMatrix(int[][] matrix, String title) {
        System.out.println(title);
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%3d ", value); // Format for alignment
            }
            System.out.println();
        }
        System.out.println();
    }

    /*
     * Main method to demonstrate the functionality of the class.
     */
    public static void main(String[] args) {
        // Test Case 1
        int[][] matrix1 = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        System.out.println("Test Case 1:");
        printMatrix(matrix1, "Initial Matrix:");
        long startTime = System.nanoTime();
        rotate(matrix1);
        long endTime = System.nanoTime();
        printMatrix(matrix1, "Rotated Matrix:");
        System.out.println("Runtime: " + (endTime - startTime) + " nanoseconds");
        System.out.println("\n" + "=".repeat(50) + "\n");

        // Test Case 2
        int[][] matrix2 = {
                { 5, 1, 9, 11 },
                { 2, 4, 8, 10 },
                { 13, 3, 6, 7 },
                { 15, 14, 12, 16 }
        };
        System.out.println("Test Case 2:");
        printMatrix(matrix2, "Initial Matrix:");
        startTime = System.nanoTime();
        rotate(matrix2);
        endTime = System.nanoTime();
        printMatrix(matrix2, "Rotated Matrix:");
        System.out.println("Runtime: " + (endTime - startTime) + " nanoseconds");
        System.out.println("\n" + "=".repeat(50) + "\n");

        // Test Case 3 (Single Element)
        int[][] matrix3 = {
                { 42 }
        };
        System.out.println("Test Case 3:");
        printMatrix(matrix3, "Initial Matrix:");
        startTime = System.nanoTime();
        rotate(matrix3);
        endTime = System.nanoTime();
        printMatrix(matrix3, "Rotated Matrix:");
        System.out.println("Runtime: " + (endTime - startTime) + " nanoseconds");
        System.out.println("\n" + "=".repeat(50) + "\n");

        // Test Case 4 (All Elements the Same)
        int[][] matrix4 = {
                { 2, 2, 2 },
                { 2, 2, 2 },
                { 2, 2, 2 }
        };
        System.out.println("Test Case 4:");
        printMatrix(matrix4, "Initial Matrix:");
        startTime = System.nanoTime();
        rotate(matrix4);
        endTime = System.nanoTime();
        printMatrix(matrix4, "Rotated Matrix:");
        System.out.println("Runtime: " + (endTime - startTime) + " nanoseconds");
        System.out.println("\n" + "=".repeat(50) + "\n");
    }
}