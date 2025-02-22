package Validsudoku;

import java.util.HashSet;
import java.util.Set;

/* Date: 2/21/2025
 * Problem Name: Valid Sudoku
 * Problem description: Determine if a 9 x 9 Sudoku board is valid. 
 * Author: @Jgriff1995 
 * Link: https://leetcode.com/problems/valid-sudoku/description/
 */

public class ValidSudokuSolution {
    /*
     * Solution
     * Time Complexity: O(1), Space Complexity: O(1)
     * Explanation: The board size is fixed (9x9), so the time and space complexity
     * are constant.
     */
    public static boolean isValidSudoku(char[][] board) {
        // Initialize data structures to hold rows, columns, and 3x3 sub-boxes
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] columns = new HashSet[9];
        Set<Character>[] subBoxes = new HashSet[9];

        // Populate Data structures
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            subBoxes[i] = new HashSet<>();
        }

        // Iterate through board with nested for loops
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char value = board[i][j];

                // skip empty cells
                if (value == '.') {
                    continue;
                }

                // calc subBoxIndex and check for duplicates in any of the data sets
                int subBoxIndex = (i / 3) * 3 + (j / 3);

                if (rows[i].contains(value) || columns[j].contains(value) || subBoxes[subBoxIndex].contains(value)) {
                    return false; // invalid board: duplicate found
                }

                // Add the value to the respective row, column and sub-box sets
                rows[i].add(value);
                columns[j].add(value);
                subBoxes[subBoxIndex].add(value);
            }
        }

        // no dupes found, board is valid
        return true;
    }

    /*
     * Helper method to print the Sudoku board in a readable format.
     */
    public static void printBoard(char[][] board, String title) {
        System.out.println(title);
        System.out.println("+-------+-------+-------+");
        for (int i = 0; i < 9; i++) {
            System.out.print("| ");
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
                if ((j + 1) % 3 == 0) {
                    System.out.print("| ");
                }
            }
            System.out.println();
            if ((i + 1) % 3 == 0) {
                System.out.println("+-------+-------+-------+");
            }
        }
    }

    /*
     * Main method to demonstrate the functionality of the class.
     */
    public static void main(String[] args) {
        char[][] board1 = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };

        char[][] board2 = {
                { '8', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };

        // Print and validate board1
        printBoard(board1, "Sudoku Board 1:");
        long startTime = System.nanoTime();
        boolean isValid1 = isValidSudoku(board1);
        long endTime = System.nanoTime();
        System.out.println("\nIs Board 1 valid? " + (isValid1 ? "Yes" : "No"));
        System.out.println("Runtime: " + (endTime - startTime) + " nanoseconds");
        System.out.println("\n" + "=".repeat(50) + "\n");

        // Print and validate board2
        printBoard(board2, "Sudoku Board 2:");
        startTime = System.nanoTime();
        boolean isValid2 = isValidSudoku(board2);
        endTime = System.nanoTime();
        System.out.println("\nIs Board 2 valid? " + (isValid2 ? "Yes" : "No"));
        System.out.println("Runtime: " + (endTime - startTime) + " nanoseconds");
        System.out.println("\n" + "=".repeat(50) + "\n");
    }
}