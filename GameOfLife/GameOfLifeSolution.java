package GameOfLife;

/* Date: 2/21/2025
 * Problem Name: Game of Life
 * Problem description: Given a 2D grid representing the current state of a cellular automaton, update the grid to its next state based on the rules of the Game of Life.
 * Author: @Jgriff1995
 * Link: https://leetcode.com/problems/game-of-life/description
 */

public class GameOfLifeSolution {

    /*
     * Solution 1: In-Place Update
     * Time Complexity: O(m × n), Space Complexity: O(1)
     * Explanation: We iterate through the grid twice:
     * - First pass: Count live neighbors and mark cells that will change state.
     * - Second pass: Apply the changes based on the marks.
     * Since the grid size is fixed, the time and space complexity are constant.
     */
    public static void gameOfLife(int[][] board) {
        // Directions for 8 neighbors
        int[][] directions = {
                { -1, -1 }, { -1, 0 }, { -1, 1 },
                { 0, -1 }, { 0, 1 },
                { 1, -1 }, { 1, 0 }, { 1, 1 }
        };

        int numRows = board.length;
        int numColumns = board[0].length;

        // First Pass: Mark cells that will change state
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                int liveNeighbors = 0;

                // Count live neighbors
                for (int[] direction : directions) {
                    int x = i + direction[0];
                    int y = j + direction[1];

                    // Make sure neighbor is in bounds & is alive
                    if (x >= 0 && x < numRows && y >= 0 && y < numColumns && (board[x][y] == 1 || board[x][y] == 2)) {
                        liveNeighbors++;
                    }
                }

                // Apply rules
                if (board[i][j] == 1) { // Live cell
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[i][j] = 2; // Mark as dying
                    }
                } else { // Dead cell
                    if (liveNeighbors == 3) {
                        board[i][j] = 3; // Mark as becoming alive
                    }
                }
            }
        }

        // Second Pass: Update the board
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0; // Dead
                } else if (board[i][j] == 3) {
                    board[i][j] = 1; // Become alive
                }
            }
        }
    }

    /*
     * Helper method to print the board in a visually appealing format.
     */
    public static void printBoard(int[][] board, String title) {
        System.out.println(title);
        System.out.println("+-------+");
        for (int i = 0; i < board.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
                if ((j + 1) % 3 == 0) {
                    System.out.print("| ");
                }
            }
            System.out.println();
            if ((i + 1) % 3 == 0) {
                System.out.println("+-------+");
            }
        }
    }

    /*
     * Main method to demonstrate the functionality of the class.
     */
    public static void main(String[] args) {
        // Test Case 1
        int[][] board1 = {
                { 0, 1, 0 },
                { 0, 0, 1 },
                { 1, 1, 1 },
                { 0, 0, 0 }
        };
        System.out.println("Test Case 1:\n");
        printBoard(board1, "Initial Board:\n");
        long startTime = System.nanoTime();
        gameOfLife(board1);
        long endTime = System.nanoTime();
        printBoard(board1, "\nUpdated Board:");
        System.out.println("\nRuntime: " + (endTime - startTime) + " nanoseconds");
        System.out.println("\n" + "=".repeat(50) + "\n");

        // Test Case 2
        int[][] board2 = {
                { 1, 1 },
                { 1, 0 }
        };
        System.out.println("Test Case 2:\n");
        printBoard(board2, "Initial Board:\n");
        startTime = System.nanoTime();
        gameOfLife(board2);
        endTime = System.nanoTime();
        printBoard(board2, "\nUpdated Board:");
        System.out.println("\nRuntime: " + (endTime - startTime) + " nanoseconds");
        System.out.println("\n" + "=".repeat(50) + "\n");

        // Test Case 3 (All Dead)
        int[][] board3 = {
                { 0, 0, 0 },
                { 0, 0, 0 },
                { 0, 0, 0 }
        };
        System.out.println("Test Case 3:\n");
        printBoard(board3, "Initial Board:\n");
        startTime = System.nanoTime();
        gameOfLife(board3);
        endTime = System.nanoTime();
        printBoard(board3, "\nUpdated Board:");
        System.out.println("\nRuntime: " + (endTime - startTime) + " nanoseconds");
        System.out.println("\n" + "=".repeat(50) + "\n");

        // Test Case 4 (All Alive)
        int[][] board4 = {
                { 1, 1, 1 },
                { 1, 1, 1 },
                { 1, 1, 1 }
        };
        System.out.println("Test Case 4:\n");
        printBoard(board4, "Initial Board:\n");
        startTime = System.nanoTime();
        gameOfLife(board4);
        endTime = System.nanoTime();
        printBoard(board4, "\nUpdated Board:");
        System.out.println("\nRuntime: " + (endTime - startTime) + " nanoseconds");
        System.out.println("\n" + "=".repeat(50) + "\n");
    }
}